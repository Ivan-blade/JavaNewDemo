package com.ivan.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ivan.exception.DataInvalidException;
import com.ivan.exception.DataNotFoundException;
import com.ivan.model.AttachData;
import com.ivan.model.HBaseModel;
import com.ivan.service.HBaseService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class HBaseServiceImpl implements HBaseService {
    private static Logger LOGGER = LoggerFactory.getLogger(HBaseServiceImpl.class);

    @Autowired
    private Connection hbaseConn;

    public void createTable(String tableName,String colFamily) {
        try {
            Admin admin = hbaseConn.getAdmin();
            //创建表描述器
            HTableDescriptor teacher = new HTableDescriptor(TableName.valueOf(tableName));
            //设置列族描述器
            teacher.addFamily(new HColumnDescriptor(colFamily));
            //执行创建操作
            admin.createTable(teacher);
            System.out.println(tableName+ "表创建成功!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void save(HBaseModel hBaseModel) throws DataInvalidException, IOException {
        String tableNameStr = hBaseModel.getTableName();
        String rowkey = hBaseModel.getRowkey();
        List<AttachData> list = hBaseModel.getAttachDataList();
        if(StringUtils.isBlank(tableNameStr)) {
            throw new DataInvalidException("保存HBase附件时表名为空");
        }
        if(StringUtils.isBlank(rowkey)) {
            throw new DataInvalidException("保存HBase附件时rowkey为空");
        }
        if(CollectionUtils.isEmpty(list)){
            throw new DataInvalidException("保存HBase附件时数据列表为空");
        }
        TableName tableName = TableName.valueOf(tableNameStr);
        Put put = formGet(rowkey,list);
        Table table = hbaseConn.getTable(tableName);
        table.put(put);
    }

    public HBaseModel query(String tableNameStr, String rowkey) throws DataInvalidException, DataNotFoundException,IOException{
        if(StringUtils.isBlank(tableNameStr)) {
            throw new DataInvalidException("保存HBase附件时表名为空");
        }
        if(StringUtils.isBlank(rowkey)) {
            throw new DataInvalidException("保存HBase附件时rowkey为空");
        }
        HBaseModel hBaseModel = new HBaseModel();
        hBaseModel.setRowkey(rowkey);
        hBaseModel.setTableName(rowkey);
        TableName tableName = TableName.valueOf(tableNameStr);
        Table table = hbaseConn.getTable(tableName);
        Get get = new Get(rowkey.getBytes());
        //先判断是否有此条数据
        if(!get.isCheckExistenceOnly()){
            List<AttachData> list = new ArrayList<>();
            Result result = table.get(get);
            Map<String,Map<String,String>> familyMap = new HashMap<>();
            if(result.isEmpty()) {
                throw new DataNotFoundException("Hbase指定rowkey未搜索到，表為:"+tableNameStr+",rowkey為:"+rowkey);
            }
            for (Cell cell : result.rawCells()){
                String family = Bytes.toString(cell.getFamily());
                String colName = Bytes.toString(cell.getQualifierArray(),cell.getQualifierOffset(),cell.getQualifierLength());
                String value = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                if(familyMap.containsKey(family)) {
                    familyMap.get(family).put(colName,value);
                }else {
                    Map<String,String> map = new HashMap<>();
                    map.put(colName,value);
                    familyMap.put(family,map);
                }
            }
            for(Map.Entry<String,Map<String,String>> entry : familyMap.entrySet()) {
                AttachData attachData = new AttachData();
                attachData.setFamilyName(entry.getKey());
                String json = JSON.toJSONString(entry.getValue());
                attachData.setFieldValue(json);
                list.add(attachData);
            }
            hBaseModel.setAttachDataList(list);
        }
        return hBaseModel;
    }

    public void delete(String tableNameStr, String rowkey) throws DataInvalidException,IOException{
        if(StringUtils.isBlank(tableNameStr)) {
            throw new DataInvalidException("保存HBase附件时表名为空");
        }
        if(StringUtils.isBlank(rowkey)) {
            throw new DataInvalidException("保存HBase附件时rowkey为空");
        }
        TableName tableName = TableName.valueOf(tableNameStr);
        Table table = hbaseConn.getTable(tableName);
        Delete delete = new Delete(Bytes.toBytes(rowkey));
        table.delete(delete);
    }

    public Put formGet(String rowkey, List<AttachData> list) {
        Put put = new Put(Bytes.toBytes(rowkey));
        for(AttachData attachData : list){

            // 列和列值存储在fieldValue中,该变量以map形式保存列族和列值
            Map<String,String> mapData = JSONObject.parseObject(attachData.getFieldValue(),Map.class);
            Iterator iter = mapData.keySet().iterator();
            while (iter.hasNext()) {
                String columnName = iter.next().toString();
                String columnValue = mapData.get(columnName);
                put.addColumn(Bytes.toBytes(attachData.getFamilyName()), Bytes.toBytes(columnName), Bytes.toBytes(columnValue));
            }
        }
        return put;
    }

    @Override
    public List<HBaseModel> scan(String tableName) throws Exception{
        List<HBaseModel> list = new ArrayList<>();
        List<String> rowkeys = new ArrayList<>();
        int count = 0;
        //读取表
        Table table = hbaseConn.getTable(TableName.valueOf(tableName));
        //全表扫描
        Scan scan=new Scan();
        ResultScanner results = table.getScanner(scan);
        for (Result result : results) {
            HBaseModel hBaseModel = new HBaseModel();
            Map<String,Map<String,String>> map = new HashMap<>();
            String rowkey = null;
            for (Cell cell : result.rawCells()) {
                rowkey = new String(CellUtil.cloneRow(cell),"UTF-8");
                String family = new String(CellUtil.cloneFamily(cell),"UTF-8");
                String columnName = new String(CellUtil.cloneQualifier(cell),"UTF-8");
                String columnValue = columnValue = new String(CellUtil.cloneValue(cell),"UTF-8");


                if(map.containsKey(family)) {
                    map.get(family).put(columnName,columnValue);
                }else {
                    Map<String,String> innerMap = new HashMap<>();
                    innerMap.put(columnName,columnValue);
                    map.put(family,innerMap);
                }
            }
            List<AttachData> attachDataList = new ArrayList<>();
            for(Map.Entry<String,Map<String,String>> entry : map.entrySet()) {
                AttachData attachData = new AttachData();
                attachData.setFamilyName(entry.getKey());
                attachData.setFieldValue(JSON.toJSONString(entry.getValue()));
                attachDataList.add(attachData);
            }
            hBaseModel.setAttachDataList(attachDataList);
            hBaseModel.setRowkey(rowkey);
            hBaseModel.setTableName(tableName);
            count++;
            list.add(hBaseModel);
            rowkeys.add(rowkey);

            if(count>=10000000) {
                results.close();
                table.close();
            }
        }

        // 关闭资源
        results.close();
        table.close();

        return list;
    }
}

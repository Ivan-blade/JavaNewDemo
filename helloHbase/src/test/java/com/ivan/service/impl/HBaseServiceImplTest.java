package com.ivan.service.impl;

import com.alibaba.fastjson.JSON;
import com.ivan.BaseTest;
import com.ivan.exception.DataInvalidException;
import com.ivan.exception.DataNotFoundException;
import com.ivan.model.AttachData;
import com.ivan.model.HBaseModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hylu.ivan
 * @date 2022/2/7 下午10:08
 * @description
 */
public class HBaseServiceImplTest extends BaseTest {

    @Autowired
    private HBaseServiceImpl hBaseService;

    @Test
    public void testCreateTable() {
        hBaseService.createTable("teacher","info");
    }

    @Test
    public void testSave() {
        HBaseModel hBaseModel = new HBaseModel();
        hBaseModel.setTableName("teacher");
        hBaseModel.setRowkey("110");
        List<AttachData> list = new ArrayList<>();
        AttachData attachData = new AttachData();
        attachData.setFamilyName("info");
        HashMap<String,String> map = new HashMap<>();
        map.put("addr","beijing");
        attachData.setFieldValue(JSON.toJSONString(map));
        list.add(attachData);

        hBaseModel.setAttachDataList(list);

        try {
            hBaseService.save(hBaseModel);
        } catch (DataInvalidException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuery() {
        String tableName = "teacher";
        String rowKey = "110";
        try {
            HBaseModel query = hBaseService.query(tableName, rowKey);
            System.out.println(query);
            List<Map<String, String>> attachDataListForMap = query.getAttachDataListForMap();
            for (Map<String, String> stringStringMap : attachDataListForMap) {
                System.out.println(stringStringMap);
            }

        } catch (DataInvalidException e) {
            e.printStackTrace();
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testDelete() {
        String tableName = "teacher";
        String rowKey = "110";

        try {
            hBaseService.delete(tableName,rowKey);
        } catch (DataInvalidException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testScan() {
        String tableName = "teacher";
        try {
            List<HBaseModel> scan = hBaseService.scan(tableName);
            System.out.println(scan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
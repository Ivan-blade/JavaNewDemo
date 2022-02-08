package com.ivan.service;

import com.ivan.exception.DataInvalidException;
import com.ivan.exception.DataNotFoundException;
import com.ivan.model.HBaseModel;

import java.io.IOException;
import java.util.List;

/**
 * @author hylu.ivan
 * @date 2022/2/7 下午10:04
 * @description
 */
public interface HBaseService {
    /**
     *@Description Hbase数据保存方法
     *@Param [hBaseModel] 存储保存内容及相关属性的对象
     *@Return void
     */
    public void save(HBaseModel hBaseModel) throws DataInvalidException, IOException;
    /**
     *@Description Hbase數據查詢方法
     *@Param [tableNameStr, rowkey] 表名，rowkey
     *@Return com.wind.bdg.middlewarelearndemo.model.HBaseModel 存储保存内容及相关属性的对象
     */
    public HBaseModel query(String tableNameStr, String rowkey) throws DataInvalidException, DataNotFoundException,IOException;
    /**
     *@Description Hbase數據刪除方法
     *@Param [tableNameStr, rowkey] 表名，rowkey
     *@Return void
     */
    public void delete(String tableNameStr, String rowkey) throws DataInvalidException,IOException;

    public List<HBaseModel> scan(String tableName)  throws Exception;
}

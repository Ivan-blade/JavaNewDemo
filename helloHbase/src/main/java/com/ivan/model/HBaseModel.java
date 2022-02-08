package com.ivan.model;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HBaseModel {

    // 表名
    private String tableName;
    // rowkey
    private String rowkey;
    // rowkey下的各个列族以及列族中的列名和列值
    private List<AttachData> attachDataList;

    public List<Map<String,String>> getAttachDataListForMap() {
        List<Map<String,String>> res = new ArrayList<>();
        for (AttachData attachData : attachDataList) {
            Map<String, String> fieldValueForMap = attachData.getFieldValueForMap();
            res.add(fieldValueForMap);
        }
        return res;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

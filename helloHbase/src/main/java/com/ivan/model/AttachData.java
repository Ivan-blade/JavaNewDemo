package com.ivan.model;


import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttachData {

    // 列族
    private String familyName;

    // 列名和列值的map转json字符串
    private String fieldValue;

//    private String binaryName;

    public Map<String,String> getFieldValueForMap() {
        Map<String,String> map = JSON.parseObject(fieldValue, Map.class);
        return map;
    }

}

package com.ivan.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hylu.ivan
 * @date 2022/3/8 下午11:52
 * @description
 */
public class HashMapTest {


    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.getOrDefault("123",1);
    }
}

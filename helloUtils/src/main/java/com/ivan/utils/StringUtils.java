package com.ivan.utils;

import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;

/**
 * @author hylu.ivan
 * @date 2022/2/9 下午8:00
 * @description
 */
public class StringUtils {


    /**
     * @param interval 间隔符号
     * @param start 起始符号
     * @param end 结尾符号
     * @param args 拼接参数
     * @return
     */
    public static String combineParams(String interval,String start,String end,String ...args) {
        StringJoiner stringJoiner = new StringJoiner(interval, start, end);
        for (String arg : args) {
            stringJoiner.add(arg);
        }
        return stringJoiner.toString();
    }

    public static String combineList(String interval,String start,String end,List<String> list) {
        StringJoiner stringJoiner = new StringJoiner(interval, start, end);
        for (String arg : list) {
            stringJoiner.add(arg);
        }
        return stringJoiner.toString();
    }

    public static String getUUid() {
        return UUID.randomUUID().toString();
    }


    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        String combine = combineParams("\t", "{", "}" );
//        System.out.println(combine);

        String uUid = getUUid();
        System.out.println(uUid);
    }
}

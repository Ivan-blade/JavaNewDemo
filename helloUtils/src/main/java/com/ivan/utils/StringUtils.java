package com.ivan.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
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


    /**
     * 根据map获取对象
     * @param map
     * @param clazzpath 全限定类名
     * @return
     */
    public static Object getObjectFromMap(Map<String,Object> map, String clazzpath) {
        try {
            Class c = Class.forName(clazzpath);
            Constructor constructor = c.getConstructor();

            Object object = constructor.newInstance();
            Field[] declaredFields = c.getDeclaredFields();

            // 遍历类中定义的所有变量
            for (Field declaredField : declaredFields) {
                // 获取变量名
                String name = declaredField.getName();
                // 如果map中存在则进行赋值
                if (map.containsKey(name)) {
                    // 取消访问检查，否则私有变量无法赋值
                    declaredField.setAccessible(true);
                    declaredField.set(object,map.get(name));
                }
            }

            return object;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        String combine = combineParams("\t", "{", "}" );
//        System.out.println(combine);

        String uUid = getUUid();
        System.out.println(uUid);
    }
}

package com.ivan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hylu.ivan
 * @date 2022/2/9 下午8:00
 * @description
 */
public class DateUtils {

    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDD = "yyyy-MM-dd";

    public static String getFormatTime(String format) {
        Date dd=new Date();
        //格式化
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String time = sdf.format(dd);
        return time;
    }

    public static String getCurrentDateTime() {
        String formatTime = getFormatTime(YYYYMMDDHHMMSS);
        return formatTime;
    }

    public static String getCurrentDate() {
        String formatTime = getFormatTime(YYYYMMDD);
        return formatTime;
    }

    public static void main(String[] args) {

        String currentDateTime = DateUtils.getCurrentDateTime();
        String currentDate = DateUtils.getCurrentDate();
        System.out.println(currentDateTime);
        System.out.println(currentDate);
    }
}

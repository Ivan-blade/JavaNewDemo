package com.ivan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hylu.ivan
 * @date 2022/3/29 下午8:34
 * @description
 */
public class Test02 {

    public static List<String> flag = new ArrayList<>();

    public static String deal(int left,int right,String str) {
        if (left == 0 && right == 0) flag.add(str);
        if (left > 0) deal(left-1,right,str+"(");
        if (right > left) deal(left,right-1,str+")");
        return str;
    }
    // 乐观指数，忧郁指数，轻松，一致性
    // 明天重要会议要参加：一定乐观

    public static void main(String[] args) {

        deal(3, 3, "");
        System.out.println(flag);

    }
}

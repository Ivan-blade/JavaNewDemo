package com.ivan.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author hylu.ivan
 * @date 2022/2/9 下午8:05
 * @description
 */
public class TestUtils {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<Character,Integer> map = new HashMap<>();

        String str = sc.nextLine();

        for(int i = 0;i < str.length();i++) {
            Character c = Character.toLowerCase(str.charAt(i));
            int num = map.getOrDefault(c,0);
            map.put(c,num+1);
        }

        String target = sc.next();
        Character res = Character.toLowerCase(target.charAt(0));
        System.out.println(map.getOrDefault(res,0));
    }
}

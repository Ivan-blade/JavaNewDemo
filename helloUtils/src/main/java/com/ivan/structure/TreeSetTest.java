package com.ivan.structure;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author hylu.ivan
 * @date 2022/3/8 下午11:49
 * @description
 */
public class TreeSetTest {


    public static void main(String[] args) {

        // 自然排序和逆序
//        Set<Integer> set = new TreeSet<>(Comparator.naturalOrder());
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        String str = "abc";
        set.add(3);
        set.add(1);
        set.add(2);

        for(Integer temp : set) {
            System.out.println(temp);
        }
    }
}

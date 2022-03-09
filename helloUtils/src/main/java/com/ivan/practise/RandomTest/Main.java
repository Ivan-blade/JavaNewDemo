package com.ivan.practise.RandomTest;

import java.util.*;

/**
 * @author hylu.ivan
 * @date 2022/3/9 上午12:31
 * @description
 */
public class Main{

    public static boolean isZhishu(Long num) {

        for(int i = 1; i <= num/2;i++) {
            Long temp = num/i;
            Long rest = num % i;
            if(rest == 0 && temp != 1 && temp != num) {
                return false;
            }
        }
        return true;
    }

    public static boolean isyinsu(Long num,Long target) {
        if( target == 1) return false;
        return num % target == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Long num = sc.nextLong();

        Queue<Long> queue = new PriorityQueue<>(Comparator.naturalOrder());

        for(Long i = 1l; i <= num/2;i++) {
            if(isZhishu(i)) {
                if(isyinsu(num,i)) {
                    queue.add(i);
                    if(isZhishu(num/i)) {
                        queue.add(num / i);
                    }
                }
            }
        }

        List<Long> res = new ArrayList<>(queue);
        for(Long tempNum : res) {
            System.out.println(tempNum);
        }
    }
}
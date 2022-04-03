package com.ivan.utils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hylu.ivan
 * @date 2022/2/9 下午8:05
 * @description
 */
public class TestUtils {

    /**
     * 滑窗，dfs，bfs，二分，普通的递归
     * @param args
     */
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strs = str.split(" ");
        Integer sum = Integer.parseInt(strs[0]);
        Integer num = Integer.parseInt(strs[1]);

//        Collections.reverse();

        int[][] dp = new int[sum][num];

        for(int i = 0;i < num;i++) {
            dp[0][i] = 1;
        }

        for(int i = 0;i < sum;i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < sum;i++){
            for(int j = 1; j < num; j++) {
                if(i < j) {
                    dp[i][j] = dp[i][i];
                } else {
                    dp[i][j] = dp[i-j][j] + dp[i][j-1];
                }
            }
        }

//        System.out.println(dp[sum][num]);
        for (int i = 0; i < dp.length; i++) {
            int[] ints = dp[i];
            System.out.println(Arrays.toString(ints));
        }
//        System.out.println(dp[sum][num]);
    }
}

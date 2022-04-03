package ClassTest;

import java.util.Arrays;

/**
 * @author hylu.ivan
 * @date 2022/3/20 下午1:32
 * @description
 */
public class ArraysTest {

    public static void test() {
        int[][] arr = new int[3][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i * arr[i].length + j + 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void main(String[] args) {

        ArraysTest.test();
    }
}

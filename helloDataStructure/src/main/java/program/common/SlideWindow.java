package program.common;

import java.util.Arrays;

/**
 * @author hylu.ivan
 * @date 2022/3/17 下午9:38
 * @description
 */
public class SlideWindow {

    /**
     * 原地删除数组中的重复元素，返回元素个数
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int j = 1;
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] != pre) {
                nums[j] = nums[i];
                pre = nums[j];
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return j;
    }

    /**
     * 计算连续递增序列
     * @param nums
     * @return
     */
    public static int calLongestArr(int[] nums) {
        
        int slow = 0;
        int fast = 1;
        if (nums.length < 2) return nums.length;

        int max = 0;
        while (fast < nums.length){
            if (nums[fast] > nums[fast-1]) {
                fast++;
            } else {
                int temp = fast - slow + 1;
                max = Math.max(temp, max);
                slow = fast;
                fast++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4,5};
//        int i = removeDuplicates(nums);
        int i = calLongestArr(nums);
        System.out.println(i);
    }
}

package program.common;

/**
 * @author hylu.ivan
 * @date 2022/3/17 下午9:38
 * @description
 */
public class BinarySearch {


    public static int binarySearch(int[] arr,int target) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int mid = (left + right)/2;
            int temp = arr[mid];

            if (temp < target) {
                left = mid + 1;
            } else if(temp > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // 9
        int[] arr = {1,2,3,4,5,6,7,8,9};

        int i = BinarySearch.binarySearch(arr, 5);
        System.out.println(i);


    }
}

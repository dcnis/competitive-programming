package array;

import utils.Utils;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        // save last k elements
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        rotate(utils.readArray("[1,2,3,4,5,6,7]"), 3);
    }
}

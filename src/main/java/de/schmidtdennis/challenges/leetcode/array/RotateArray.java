package de.schmidtdennis.challenges.leetcode.array;

import de.schmidtdennis.challenges.leetcode.utils.Utils;

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

    public void rotate1(int[] nums, int k) {

        if(nums.length == 1) return;

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length;i++){

                int index = ((i+k)%(nums.length));
                res[index] = nums[i];

        }

        for(int i = 0; i < nums.length;i++){
            nums[i] = res[i];
        }
    }

    public static void rotateInPlace(int[] nums, int k) {

        if(nums.length == 1) return;

        int count = 0;
        int i = 0;
        int temp1 = nums[0];

        while(count < nums.length){
            int newIndex = ((i+k)%(nums.length));

            int temp2 = nums[newIndex]; // 5

            nums[newIndex] = temp1; //5
            i = newIndex;
            count++;
            temp1 = temp2;
        }

    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        rotateInPlace(utils.readIntArray("[-1,-100,3,99]"), 2);
    }
}

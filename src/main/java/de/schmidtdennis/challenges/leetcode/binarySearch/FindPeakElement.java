package de.schmidtdennis.challenges.leetcode.binarySearch;

import de.schmidtdennis.challenges.leetcode.utils.Utils;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        return bs(nums, 0, nums.length-1);
    }

    private static int bs(int[] nums, int start, int end){

        int mid = (end + start) / 2;

        if(mid == 0){
            if(nums[mid+1] < nums[mid]){
                return mid;
            } else {
                return bs(nums, mid+1, end);
            }
        } else if (mid == nums.length-1){
            if(nums[mid-1] < nums[mid]){
                return mid;
            } else {
                return bs(nums, start, mid-1);
            }
        } else if(nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]){
            return mid;
        } else if(nums[mid+1] > nums[mid]){
            // search right
            return bs(nums, mid+1, end);
        } else if (nums[mid-1] > nums[mid]){
            // search left
            return bs(nums, start, mid-1);
        }

        return -1;
    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        System.out.println(findPeakElement(utils.readIntArray("[1,2,1,3,5,6,4]"))); // expected output: 5
    }
}

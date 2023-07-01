package leetcode.DP;

import leetcode.utils.Utils;

/*
*53. Maximum Subarray
* https://leetcode.com/problems/maximum-subarray/
* */
public class MaximumSubarray {

    public static int maxSubArrayConstantTime(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = nums[0];

        for(int i = 1 ; i < nums.length; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            if(dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayConstantTime(Utils.readIntArray("[5,-3]")));
    }



}

package leetcode.DP;

/*
*   918. Maximum Sum Circular Subarray
*   https://leetcode.com/problems/maximum-sum-circular-subarray/
* */
public class MaximumSumCircularSubarray {

    // Working but Timelimit exceeded
    public int maxSubarraySumCircular(int[] nums) {

        if(nums.length == 1) return nums[0];

        int n = nums.length;


        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            int maxSub = maxSubarrayStartEnd(nums, i);
            if(maxSub > max){
                max = maxSub;
            }
        }

        return max;

    }

    private int maxSubarrayStartEnd(int[] nums, int start){
        int n = nums.length;
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        int max = Integer.MIN_VALUE;
        int i = (start + 1) % n;

        for(int j = 0; j < nums.length; j++){
            int previousIndex = (i + 1) % n;

            dp[i] = Math.max(dp[previousIndex]+nums[i], nums[i]);
            if(dp[i] > max){
                max = dp[i];
            }

            i = (i - 1 + n) % n;
        }

        return max;
    }

}

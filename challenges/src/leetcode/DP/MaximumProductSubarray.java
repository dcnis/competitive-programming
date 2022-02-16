package leetcode.DP;

/*
* 152. Maximum Product Subarray
* https://leetcode.com/problems/maximum-product-subarray/
* */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        if(nums.length == 1) return nums[0];

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        int max = nums[0];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        for(int i = 1; i < nums.length; i++){

            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i-1]*nums[i], dpMin[i-1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMin[i-1]*nums[i], dpMax[i-1]*nums[i]));

            if(dpMax[i] > max){
                max = dpMax[i];
            }
        }


        return max;
    }

}

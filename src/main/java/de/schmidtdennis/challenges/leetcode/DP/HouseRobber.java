package de.schmidtdennis.challenges.leetcode.DP;

import de.schmidtdennis.challenges.leetcode.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/*
* 198. House Robber
* Link: https://leetcode.com/problems/house-robber/
* */
public class HouseRobber {

    public static int robBottomDown(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int i = nums.length-1;

        int max = 0;
        Map<String, Integer> cache = new HashMap<>();

        return robSub(nums, 0, i, cache);

    }


    public static int robSub(int[] nums, int total, int i, Map<String, Integer> cache){

        if(i < 0) return total;
        String key = total + "-" + i;
        if(cache.containsKey(key)) return cache.get(key);

        int takeFirst = robSub(nums, total+nums[i], i-2, cache);

        int takeSecond = 0;
        if(i > 0){
            takeSecond = robSub(nums, total+nums[i-1], i-3, cache);
        }

        int result = Math.max(takeFirst, takeSecond);

        cache.put(key, result);

        return result;
    }

    public static int robTopUp(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(robBottomDown(Utils.readIntArray("[1,2,3,1]"))); // 4
        System.out.println(robBottomDown(Utils.readIntArray("[2,7,9,3,1]"))); // 12
    }

}

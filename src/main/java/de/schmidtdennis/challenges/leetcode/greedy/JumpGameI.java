package de.schmidtdennis.challenges.leetcode.greedy;

import de.schmidtdennis.challenges.leetcode.utils.Utils;

/*
*
* */
public class JumpGameI {

    /* 434ms */
    public boolean canJumpWithDP(int[] nums) {
        int[] memo = new int[nums.length];
        return canJumpStartingFrom(nums, 0, memo);
    }

    private boolean canJumpStartingFrom(int[] nums, int n, int[] memo){

        if(n >= nums.length-1){
            return true;
        }

        if(memo[n] == 1){
            return true;
        } else if (memo[n] == -1){
            return false;
        }

        boolean minOneTrue = false;

        for(int i = 0; i < nums[n]; i++){
            boolean res = canJumpStartingFrom(nums, n+i+1, memo);
            if(res){
                minOneTrue = true;
                break;
            }
        }

        if(minOneTrue){
            memo[n] = 1;
        } else {
            memo[n] = -1;
        }

        return minOneTrue;
    }

    /* 2ms */
    public static boolean canJumpGreedy(int[] nums) {
        int farthest = 0;

        // we need "i <= farthest" otherwise if we use "i < nums.length",
        // we will continue to increase farthest and it will return true for [0,2,3]

        // we need && i < nums.length otherwise we would go out of bounce e.q. when farthest == 300
        for (int i = 0; i <= farthest && i < nums.length; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
        }
        return farthest >= nums.length - 1;
    }

    public static boolean canJumpGreedyBackwards(int[] nums) {
        int goal = nums.length-1;

        for(int i = nums.length-2; i >= 0; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
        }

        return goal == 0;
    }


    public static void main(String[] args) {
        System.out.println(canJumpGreedy(Utils.readIntArray("[2,3,1,1,4]")));
    }

}

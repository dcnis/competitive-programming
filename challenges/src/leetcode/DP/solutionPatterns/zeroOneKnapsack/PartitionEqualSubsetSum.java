package leetcode.DP.solutionPatterns.zeroOneKnapsack;

import leetcode.utils.Utils;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int n : nums){
            sum += n;
        }

        if((sum & 1) == 1) {
            return false;
        }

        int[][] memo = new int[nums.length+1][sum+1];

        return dp(nums, 0, sum, nums.length-1, memo);
    }

    private boolean dp(int[] nums, int sum, int total, int i, int[][] memo){

        if(sum * 2 == total) return true;

        if(i < 0 || sum*2 > total) return false;

        if(memo[i][sum] != 0){
            return memo[i][sum] * 2 == total;
        }

        boolean notTake = dp(nums, sum, total, i-1, memo);
        boolean take = dp(nums, sum+nums[i], total, i-1, memo);


        memo[i][sum] = sum;

        return notTake || take;
    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        PartitionEqualSubsetSum program = new PartitionEqualSubsetSum();
        System.out.println(program.canPartition(utils.readArray("[1,5,11,5]"))); // should return true;
        System.out.println(program.canPartition(utils.readArray("[1,2,3,5]"))); // should return false;
        // should return false;
        System.out.println(program.canPartition(utils.readArray("[100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97]")));
    }



}

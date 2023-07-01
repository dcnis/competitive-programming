package leetcode.DP;


import leetcode.utils.Utils;

public class canSum {

    public static boolean canSum(int[] nums, int targetSum){

        int[][] memo = new int[nums.length][targetSum];

        return dp(nums, nums.length-1, 0, targetSum, memo);
    }

    private static boolean dp(int[] nums, int i, int sum, int targetSum, int[][] memo){

        if(sum > targetSum) return false;
        if(sum == targetSum) return true;
        if(i < 0) return false;

        if(memo[i][sum] != 0) return memo[i][sum] == 1;

        boolean temp = false;
        if(nums[i] != 0){
            temp = dp(nums, i, sum+nums[i], targetSum, memo);
        }

        boolean ans = temp ||
                dp(nums, i-1, sum, targetSum, memo) ||
                dp(nums, i-1, sum+nums[i], targetSum, memo);

        memo[i][sum] = ans ? 1 : -1;

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(canSum(Utils.readIntArray("[0]"), 1)); // false
        System.out.println(canSum(Utils.readIntArray("[0,0,0,0]"), 1)); // false
        System.out.println(canSum(Utils.readIntArray("[3,0,0,0]"), 2)); // false

        System.out.println(canSum(Utils.readIntArray("[1,0,0,0]"), 2)); // true
        System.out.println(canSum(Utils.readIntArray("[1,1,1,1]"), 3)); // true
        System.out.println(canSum(Utils.readIntArray("[1,1,1,1]"), 4)); // true
        System.out.println(canSum(Utils.readIntArray("[1,2,3,4]"), 6)); // true
        System.out.println(canSum(Utils.readIntArray("[1,2,3,4]"), 7)); // true
        System.out.println(canSum(Utils.readIntArray("[1,2,3,4]"), 10)); // true
        System.out.println(canSum(Utils.readIntArray("[1,2,3,4]"), 11)); // true

    }

}

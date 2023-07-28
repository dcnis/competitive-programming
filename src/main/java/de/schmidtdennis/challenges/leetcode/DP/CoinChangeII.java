package de.schmidtdennis.challenges.leetcode.DP;

public class CoinChangeII {

    public int change(int amount, int[] coins) {
        return dp(amount, coins);
    }


    private int dp(int amount, int[] coins){
        if(amount == 0) return 1;
        if(amount < 0) return 0;

        int sum = 0;
        for(int i = 0; i<coins.length; i++){
            sum += dp(amount-coins[i], coins);
        }

        return sum;
    }


}

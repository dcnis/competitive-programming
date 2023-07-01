package leetcode.greedy;

import leetcode.utils.Utils;

/*
* 121. Best Time to Buy and Sell Stock
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
* */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        if(prices.length == 1) return 0;

        int smallestPriceSoFar = prices[0];
        int bestProfitSoFar = 0;

        int[] dp = new int[prices.length];

        for(int i = 1; i < prices.length;i++){

            if(prices[i] > smallestPriceSoFar){
                // I CAN MAKE A PROFIT
                int profit = prices[i] - smallestPriceSoFar;

                if(profit > bestProfitSoFar){
                    bestProfitSoFar = profit;
                }
            } else if (prices[i] < smallestPriceSoFar){
                smallestPriceSoFar = prices[i];
            }
        }

        return bestProfitSoFar;

    }

    public static void main(String[] args) {
        // 5
        System.out.println(maxProfit(Utils.readIntArray("[7,1,5,3,6,4]")));
    }
}

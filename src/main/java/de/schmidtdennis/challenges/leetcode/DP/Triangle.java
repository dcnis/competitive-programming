package de.schmidtdennis.challenges.leetcode.DP;

import java.util.List;

/*
* 120. Triangle
* https://leetcode.com/problems/triangle/
* */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle.size() == 1) return triangle.get(0).get(0);

        int rows = triangle.size();
        int columns = triangle.get(triangle.size()-1).size();

        int[][] dp = new int[rows][columns];

        for(int j = 0; j < rows; j++){
            dp[rows-1][j] = triangle.get(rows-1).get(j);
        }

        for(int i=rows-2; i >= 0; i--){
            for(int j = 0; j < i+1; j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }

}

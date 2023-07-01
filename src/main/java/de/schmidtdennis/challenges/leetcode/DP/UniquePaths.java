package de.schmidtdennis.challenges.leetcode.DP;

/*
* 62. Unique Paths
* https://leetcode.com/problems/unique-paths/
* */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        return dp(m, n, memo);
    }

    private int dp(int rows, int columns, int[][] memo){

        if(rows == 1 && columns == 1) return 1;
        if(rows == 0 || columns == 0) return 0;

        if(memo[rows][columns] != 0) return memo[rows][columns];

        int answer = dp(rows-1, columns, memo) + dp(rows, columns-1, memo);
        memo[rows][columns] = answer;
        return answer;
    }

}

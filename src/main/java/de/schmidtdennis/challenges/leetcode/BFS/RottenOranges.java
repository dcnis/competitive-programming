package de.schmidtdennis.challenges.leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
* 994. Rotting Oranges
* https://leetcode.com/problems/rotting-oranges/
* */
public class RottenOranges {

    public int orangesRotting(int[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        Queue<int[]> q = new LinkedList<>();

        int freshOranges = 0;

        int level = -1;

        // Put all rotten oranges into the queue
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) return 0;

        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};

        while(!q.isEmpty()){

            int size = q.size();
            level++;

            for(int i = 0; i < size; i++){

                int[] field = q.poll();
                grid[field[0]][field[1]] = 2;

                for(int[] direction : dirs){
                    int r = field[0] + direction[0];
                    int c = field[1] + direction[1];

                    if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) continue;

                    grid[r][c] = 2;
                    q.offer(new int[]{r, c});
                }
            }
        }


        // Check if there are still fresh oranges -> if yes return -1
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return level;
    }


}

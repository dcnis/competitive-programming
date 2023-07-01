package de.schmidtdennis.challenges.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class AreaAfterCutsDP {


    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        List<Integer> HORIZONTAL_CUTS = new ArrayList<>();
        List<Integer> VERTICAL_CUTS = new ArrayList<>();
        for(int i = 0; i < horizontalCuts.length; i++){
            HORIZONTAL_CUTS.add(horizontalCuts[i]);
        }

        for(int i = 0; i < verticalCuts.length; i++){
            VERTICAL_CUTS.add(verticalCuts[i]);
        }


        int maxArea = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[h+1][w+1];

        List<Integer> areas = new ArrayList<>();
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){

                if(visited[i][j]){
                    continue;
                }
                int currentArea = dfs(i, j, visited, h, w, HORIZONTAL_CUTS, VERTICAL_CUTS);
                areas.add(currentArea);
                if(currentArea > maxArea){
                    maxArea = currentArea;
                }
            }
        }
        return maxArea % 1000000007;
    }

    private static int dfs(int y, int x, boolean[][] visited, int h, int w, List<Integer> HORIZONTAL_CUTS, List<Integer> VERTICAL_CUTS){

        if(visited[y][x]){
            return 0;
        } else {
            visited[y][x] = true;
        }

        int rightArea = 0;
        int downArea = 0;

        if(!VERTICAL_CUTS.contains(x+1) && (x+1 != w) && !visited[y][x+1]){
            rightArea = dfs(y, x+1, visited, h, w, HORIZONTAL_CUTS, VERTICAL_CUTS);
        }

        if(!HORIZONTAL_CUTS.contains(y+1) && (y+1) != h && !visited[y+1][x]){
            downArea = dfs(y+1, x, visited, h, w, HORIZONTAL_CUTS, VERTICAL_CUTS);
        }

        return rightArea+downArea+1;
    }

    public static void main(String[] args) {
        // should return 4
        System.out.println(maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));

        // should return 6
        System.out.println(maxArea(5, 4, new int[]{3, 1}, new int[]{1}));

        // should return 51
        System.out.println(maxArea(50, 15, new int[]{37,40,41,30,27,10,31}, new int[]{2,1,9,5,4,12,6,13,11}));

    }
}

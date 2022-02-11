package leetcode.DFS;

import leetcode.utils.Utils;

import java.util.LinkedList;
import java.util.Queue;

/*
* 733. Flood Fill
* https://leetcode.com/problems/flood-fill/
* */
public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        dfs(image, sr, sc, image[sr][sc], newColor);
        Queue<Integer> q = new LinkedList<>(
        );

        return image;

    }

    private static void dfs(int[][] image, int y, int x, int oldColor, int newColor){

        if(y < 0 || y >= image.length) return;
        if(x < 0 || x >= image[0].length) return;

        if(image[y][x] == oldColor){
            image[y][x] = newColor;

            dfs(image, y-1, x, oldColor, newColor);
            dfs(image, y, x-1, oldColor, newColor);
            dfs(image, y+1, x, oldColor, newColor);
            dfs(image, y, x+1, oldColor, newColor);

        }


    }

    public static void main(String[] args) {
        int[][] arr = floodFill(Utils.read2DArray("[[0,0,0],[0,1,0]]"), 0, 0, 2);
    }

}

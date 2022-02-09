package BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
* 542. 01 Matrix
* https://leetcode.com/problems/01-matrix/
* */
public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int level = 0;

        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        while(!q.isEmpty()){
            int size = q.size();
            level++;

            for(int i = 0; i < size; i++){

                int[] element = q.poll();

                int y = element[0];
                int x = element[1];

                for(int[] direction : dirs){
                    int r = y + direction[0];
                    int c = x + direction[1];

                    if(r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] != -1) continue;

                    mat[r][c] = level;
                    q.offer(new int[]{r, c});
                }
            }


        }

        return mat;
    }

}

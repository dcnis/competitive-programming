package leetcode.matrix;

public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        if (r*c != n*m) return mat;

        int[] oneD = new int[mat.length*mat[0].length];

        // convert to 1-D

        for(int i = 0; i < mat.length;i++){
            for(int j = 0; j < mat[0].length; j++){
                oneD[n*i+j] = mat[i][j];
            }
        }

        int[][] newMat = new int[r][c];

        for(int i = 0; i < oneD.length; i++){
            newMat[i/c][i%c] = oneD[i];
        }

        return newMat;
    }

}

package de.schmidtdennis.challenges.leetcode.matrix;

import de.schmidtdennis.challenges.leetcode.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestElementInSortedMatrix {

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(n == 1) return matrix[0][0];

        List<Integer> array = new ArrayList<>(n*n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                array.add(matrix[i][j]);
            }
        }

        Collections.sort(array);
        System.out.println(array.toString());
        return array.get(k-1);
    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        // should output 13
        System.out.println(kthSmallest(utils.read2DArray("[[1,5,9],[10,11,13],[12,13,15]]"), 8));
    }
}

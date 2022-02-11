package leetcode.array;

/*
* 74. Search a 2D Matrix
* https://leetcode.com/problems/search-a-2d-matrix/
* */
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {


        int M = matrix.length * matrix[0].length - 1;

        return bs(matrix, 0, M, target);

    }

    public static  boolean bs(int[][] matrix, int start, int end, int target){

        if(start == end){
            int x = start/matrix[0].length;
            int y = start%matrix[0].length;

            return matrix[x][y] == target;
        }

        // find mid
        int mid = start+(end-start)/2;

        int x = mid/matrix[0].length;
        int y = mid%matrix[0].length;

        if(matrix[x][y] == target){
            return true;
        }

        if(matrix[x][y] > target){
            return bs(matrix, start, mid-1, target);
        } else {
            return bs(matrix, mid+1, end, target);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        };

        System.out.println(searchMatrix(matrix, 3)); // true
    }

}

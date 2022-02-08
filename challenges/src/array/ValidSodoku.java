package array;

import java.util.HashSet;
import java.util.Set;

/*
* 36. Valid Sudoku
* https://leetcode.com/problems/valid-sudoku/
* */
public class ValidSodoku {

    public static boolean isValidSudoku(char[][] board) {


        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(isCellInvalid(board, i, j)){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isCellInvalid(char[][] board, int i, int j){
        // check row
        if(isRowInvalid(board, i, j)){
            return true;
        }

        // check column
        if(isColumnInvalid(board, i, j)){
            return true;
        }

        // check subbox
        if(isSubboxInvalid(board, i, j)){
            return true;
        }

        return false;
    }

    private static boolean isRowInvalid(char[][] board, int row, int column){
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < board[0].length; i++){
            if(board[row][i] != '.'){
                if(!set.add(Character.getNumericValue(board[row][i]))){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isColumnInvalid(char[][] board, int row, int column){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < board[0].length; i++){
            if(board[i][column] != '.'){
                if(!set.add(Character.getNumericValue(board[i][column]))){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isSubboxInvalid(char[][] board, int row, int column){
        Set<Integer> set = new HashSet<>();

        int[] subbox = getSubboxCoordinates(board, row, column);
        int x = subbox[0];
        int y = subbox[1];
        for(int i = x; i < x+3; i++){
            for(int j = y; j < y+3; j++){
                if(board[i][j] != '.' && !set.add(Character.getNumericValue(board[i][j]))){
                    return true;
                }
            }
        }


        return false;
    }

    private static int[] getSubboxCoordinates(char[][] board, int row, int column){

        int[] coordinates = new int[2];

        int i = 3* (row/3);
        int j = 3* (column/3);

        coordinates[0] = i;
        coordinates[1] = j;

        return coordinates;
    }

    public static void main(String[] args) {
        char[][] invalidBoard = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] validBoard = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(validBoard)); // true
        System.out.println(isValidSudoku(invalidBoard)); // false

    }

}

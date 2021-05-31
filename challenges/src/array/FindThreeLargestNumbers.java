package array;

import java.util.Arrays;

public class FindThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.

        int[] result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int i = 0; i < array.length; i++){
            checkNumber(result, array[i]);
        }

        return result;
    }

    private static void checkNumber(int[] result, int number){

        if(number > result[2]){
            addNumberAndShift(result, number, 2);
        } else if (number > result[1]){
            addNumberAndShift(result, number, 1);
        } else if(number > result[0]){
            addNumberAndShift(result, number, 0);
        }

    }

    private static void addNumberAndShift(int[] result, int number, int shift){
        if(shift == 2){
            result[0] = result[1];
            result[1] = result[2];
            result[2] = number;
        }

        if(shift == 1){
            result[0] = result[1];
            result[1] = number;
        }

        if(shift == 0){
            result[0] = number;
        }
    }


    public static void main(String[] args) {

        int[] arr = findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7});
        System.out.println(Arrays.toString(arr));
        }

}

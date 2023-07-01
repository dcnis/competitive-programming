package de.schmidtdennis.challenges.leetcode.utils;

public class Utils {

    public static int[] readIntArray(String arrayAsString){

        if(arrayAsString.contains("[")){
            arrayAsString = arrayAsString.substring(1, arrayAsString.length()-1);
        }
        String[] splitted = arrayAsString.split(",");

        int[] array = new int[splitted.length];
        for(int i = 0; i < splitted.length; i++){
            array[i] = Integer.parseInt(splitted[i].trim());
        }
        return array;
    }

    public static String[] readStringArray(String arrayAsString){

        if(arrayAsString.contains("[")){
            arrayAsString = arrayAsString.substring(2, arrayAsString.length()-2);
        }
        return arrayAsString.split("\",\"");
    }


    public static int[][] read2DArray(String twoDarray){
        String removeBrackets = twoDarray.substring(1, twoDarray.length()-1);
        String[] splitted = removeBrackets.split("]");
        int[][] result = new int[splitted.length][];

        for(int i = 0; i < splitted.length; i++){
            splitted[i] = splitted[i].replace(",[", "[");
            splitted[i] += "]";
            result[i] = readIntArray(splitted[i]);

        }

        return result;
    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.readIntArray("[8, 5, 2, 9, 5, 6, 3]");
        utils.read2DArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
    }
}

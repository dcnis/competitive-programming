package pramp;

import leetcode.utils.Utils;

import java.io.*;
import java.util.*;

class DifferentNumber {

    static int getDifferentNumber(int[] arr) {
        // your code goes here



        for(int i = 0; i < arr.length; i++){
            int index = arr[i];
            if(index < arr.length && arr[index] != index){
                swap(arr, i, index);
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != i){
                return i;
            }
        }

        return arr.length;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        System.out.println(getDifferentNumber(Utils.readArray("[0,5,4,1,3,2]")));
    }

}

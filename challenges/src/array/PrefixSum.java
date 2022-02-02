package array;

import utils.Utils;

import java.util.Arrays;

public class PrefixSum {


    static int[] fillPrefixSum(int arr[]) {

        int[] prefixSum = new int[arr.length];

        prefixSum[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefixSum[i] += prefixSum[i-1] + arr[i];
        }

        return prefixSum;
    }


    public static void main(String[] args) {
        System.out.println("Expected: [10, 30, 40, 45, 60]");
        System.out.println(Arrays.toString(fillPrefixSum(Utils.readArray("10, 20, 10, 5, 15"))));
    }
}

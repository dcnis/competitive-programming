package leetcode.sort;

import leetcode.utils.Utils;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        // Write your code here.

        qs(array, 0, array.length-1);

        return array;
    }

    private static void qs(int[] array, int startIndex, int endIndex){

        if(startIndex >= endIndex){
            return;
        }

        // choose pivot
        int pivot = array[endIndex];

        // partition
        int j = startIndex;
        for(int i = startIndex; i < endIndex; i++){

            if(array[i] < pivot){
                // swap leetcode.array[i] with leetcode.array[j]
                // increase j
                if(array[i] != array[j]){
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
                j++;
            }
        }
        // switching pivot with leetcode.array[j]
        int tmp = array[j];
        array[j] = array[endIndex];
        array[endIndex] = tmp;

        // Call qs on halfs
        qs(array, startIndex, j-1);
        qs(array, j+1, endIndex);
    }

    public static void main(String[] args) {
        Utils utils = new Utils();

        System.out.println(Arrays.toString(QuickSort.quickSort(utils.readArray("[8, 5, 2, 9, 5, 6, 3]"))));
        System.out.println(Arrays.toString(QuickSort.quickSort(utils.readArray("[1]"))));
        System.out.println(Arrays.toString(QuickSort.quickSort(utils.readArray("[-4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1, " +
                "6, -7, -6, -7, 8]"))));
        QuickSort.quickSort(utils.readArray("[4, 2, 1, 3]"));
        QuickSort.quickSort(utils.readArray("[8, 5, 2, 9]"));
    }
}

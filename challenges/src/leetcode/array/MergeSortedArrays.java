package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrays {

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // Write your code here.
        return helper(arrays);
    }

    private static List<Integer> helper(List<List<Integer>> lists) {

        if (lists.size() == 1) {
            return lists.get(0);
        }

        int middle = lists.size() / 2;
        int mod = lists.size() % 2;
        List<List<Integer>> firstHalf;
        List<List<Integer>> secondHalf;

        if (mod == 0) {
            firstHalf = getFirstHalf(lists, middle);
            secondHalf = getSecondHalf(lists, middle);
        } else {
            firstHalf = getFirstHalf(lists, middle);
            secondHalf = getSecondHalf(lists, middle + mod);
        }

        List<Integer> firstSortedArray = helper(firstHalf);
        List<Integer> secondSortedArray = helper(secondHalf);

        return mergeTwoArrays(firstSortedArray, secondSortedArray);
    }

    private static List<Integer> mergeTwoArrays(List<Integer> firstList, List<Integer> secondList) {
        int i = 0;
        int j = 0;
        List<Integer> sorted = new ArrayList<>();

        while (i < firstList.size() && j < secondList.size()) {
            if (firstList.get(i) < secondList.get(j)) {
                sorted.add(firstList.get(i));
                i++;
            } else {
                sorted.add(secondList.get(j));
                j++;
            }
        }

        // Copy rest of the leetcode.array to the Array
        while (i < firstList.size()) {
            sorted.add(firstList.get(i));
            i++;
        }

        // Copy rest of the leetcode.array to the Array
        while (j < secondList.size()) {
            sorted.add(secondList.get(j));
            j++;
        }

        return sorted;
    }

    private static List<List<Integer>> getFirstHalf(List<List<Integer>> lists, int amount) {
        List<List<Integer>> newList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            newList.add(lists.get(i));
        }
        return newList;
    }

    private static List<List<Integer>> getSecondHalf(List<List<Integer>> lists, int amount) {
        List<List<Integer>> newList = new ArrayList<>();

        for (int i = lists.size() - 1; i >= (lists.size() - amount); i--) {
            newList.add(lists.get(i));
        }
        return newList;
    }

    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();

        List<Integer> one = Arrays.asList(1, 5, 9, 21);
        List<Integer> two = Arrays.asList(-1, 0);
        List<Integer> four = Arrays.asList(3, 6, 12);

        array.add(one);
        array.add(two);
        array.add(four);

        List<Integer> sorted = mergeSortedArrays(array);
        System.out.println(sorted);
    }
}

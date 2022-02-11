package leetcode.array;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        return bs(array, 0, array.length - 1, target);
    }

    private static int bs(int[] array, int startIndex, int endIndex, int target) {

        if (startIndex > endIndex) {
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;

        if (array[mid] == target) return mid;

        if (array[mid] < target) {
            // we need to go left
            return bs(array, mid + 1, endIndex, target);
        } else {
            // we need to go right
            return bs(array, startIndex, mid - 1, target);
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 5, 23, 111};
        System.out.println(binarySearch(array, 5));
    }
}

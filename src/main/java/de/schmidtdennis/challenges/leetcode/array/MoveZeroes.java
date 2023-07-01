package de.schmidtdennis.challenges.leetcode.array;


import de.schmidtdennis.challenges.leetcode.utils.Utils;

import java.util.Arrays;

/*
* 283. Move Zeroes
* https://leetcode.com/problems/move-zeroes/
* */
public class MoveZeroes {


    public static void moveZeroesSolution1(int[] nums) {

        if (nums.length == 1) return;

        int p1 = 0, p2 = 0;


        outer: while(p1 < nums.length && p2 < nums.length){

            if(nums[p1] != 0) {
                p1++;
                p2++;
                continue;
            }

            // p2 find next number
            while(nums[p2] == 0){
                p2++;
                if(p2 > (nums.length-1)){
                    continue outer;
                }
            }

            swap(nums, p1, p2);
            p1++;


        }

    }

    private static void moveZeroesSolution2(int[] nums) {
        if (nums.length == 1) return;

        int p2 = 0;

        for(int p1=0; p1 < nums.length;p1++){
            if(nums[p1] != 0){
                swap(nums, p1, p2++);
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = Utils.readIntArray("[0,1,0,3,12]");
        moveZeroesSolution1(nums);
        System.out.println(Arrays.toString(nums)); // [1, 3, 12, 0, 0]

        int[] nums2 = Utils.readIntArray("[0, 0, 12, 14, 0]");
        moveZeroesSolution1(nums2);
        System.out.println(Arrays.toString(nums2)); // [12,14,0,0,0]

    }
}

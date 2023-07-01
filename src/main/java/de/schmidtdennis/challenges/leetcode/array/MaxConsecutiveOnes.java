package de.schmidtdennis.challenges.leetcode.array;

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int currentCounter = 0;
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                currentCounter++;
            } else {
                if(currentCounter > max){
                    max = currentCounter;
                }
                currentCounter = 0;
            }
        }

        if(currentCounter > max){
            max = currentCounter;
        }

        return max;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}

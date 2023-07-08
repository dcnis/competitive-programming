package de.schmidtdennis.challenges.leetcode.DP.freeCodeCampDPCourse;

import java.util.ArrayList;
import java.util.List;

public class HowSum {

    public List<Integer> howSum(int[] nums, int target){
        return howSum(target, nums);
    }

    private List<Integer> howSum(int target, int[] nums){

        if(target < 0) return null;
        if(target == 0) return new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            List<Integer> arr = howSum(target - nums[i], nums);
            if(arr != null){
                arr.add(nums[i]);
                return arr;
            }
        }

        return null;
    }

}

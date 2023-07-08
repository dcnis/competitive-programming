package de.schmidtdennis.challenges.leetcode.DP.freeCodeCampDPCourse;

import java.util.ArrayList;
import java.util.List;

public class HowSum {

    public List<List<Integer>> howSum(int[] nums, int target){

        List<List<Integer>> answer = new ArrayList<>();
        howSum(new ArrayList<>(), nums, target, answer);
        return answer;
    }

    private void howSum(List<Integer> cur, int[] nums, int target, List<List<Integer>> answer){

        if(target < 0) return;
        if(target == 0){
            answer.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            cur.add(nums[i]);
            howSum(cur, nums, target - nums[i], answer);
            cur.remove(cur.size()-1);
        }

    }

}

package de.schmidtdennis.challenges.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    public List<List<Integer>> subsets(int[] nums){

        // 1,2,3
        List<List<Integer>> answ = new ArrayList<>();
        deep(new ArrayList<>(), 0, nums, answ);
        return answ;
    }

    private void deep(List<Integer> cur, int i, int[] nums, List<List<Integer>> answ){
        if(i == nums.length){
            answ.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        deep(cur, i+1, nums, answ);
        cur.remove(cur.size()-1);
        deep(cur, i+1, nums, answ);

    }

}

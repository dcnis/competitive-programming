package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* 77. Combinations
* https://leetcode.com/problems/combinations/
* */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> permutations = new ArrayList<>();

        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = i+1;
        }

        for(int i = 0; i < n; i++){
            LinkedList<Integer> curr = new LinkedList<>();
            curr.add(nums[i]);
            perm(nums, i, k, curr, permutations);
            curr.remove(Integer.valueOf(nums[i]));
        }

        return permutations;
    }

    private void perm(int[] nums, int i, int k, List<Integer> curr, List<List<Integer>> permutations){

        if(curr.size() == k){
            permutations.add(new ArrayList<>(curr));
            return;
        }

        for(int j = i+1; j < nums.length; j++){
            curr.add(nums[j]);
            perm(nums, j, k, curr, permutations);
            curr.remove(Integer.valueOf(nums[j]));
        }

    }

}

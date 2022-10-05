package leetcode.backtracking;

import java.util.*;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] can, int target) {

        Set<List<Integer>> solution = new HashSet<>();
        LinkedList<Integer> cur = new LinkedList<>();
        backtrack(0, cur, 0, solution, can, target);
        return new ArrayList<>(solution);
    }


    private void backtrack(int i, LinkedList<Integer> cur, int sum, Set<List<Integer>> solution, int[] can, int target){


        if(sum == target){
            solution.add(new ArrayList<>(cur));
            return;
        }

        if(sum > target) return;
        if(i > can.length-1) return;

        cur.offer(can[i]);
        backtrack(i+1, cur, sum+can[i], solution, can, target);
        backtrack(i, cur, sum+can[i], solution, can, target);
        cur.removeLast();

        backtrack(i+1, cur, sum, solution, can, target);
    }

    private void backtrack(int first, LinkedList<Integer> cur, int sum, List<List<Integer>> solution, int[] can, int target){

        if(sum == target){
            solution.add(new ArrayList<>(cur));
            return;
        }

        if(sum > target) return;

        for(int i = first; i < can.length; i++){
            cur.offer(can[i]);
            backtrack(i, cur, sum+can[i], solution, can, target);
            cur.removeLast();
        }

    }

}

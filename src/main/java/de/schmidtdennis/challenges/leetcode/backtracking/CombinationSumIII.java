package de.schmidtdennis.challenges.leetcode.backtracking;

/*
* 216. Combination Sum III
* https://leetcode.com/problems/combination-sum-iii/
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {


    public static List<List<Integer>> combinationSum3(int k, int n) {


        List<List<Integer>> solution = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        backtrack(1, cur, solution, k, n, 0);
        return solution;
    }

    private static void backtrack(int first, LinkedList<Integer> cur, List<List<Integer>> solution, int k, int n, int sum){

        if(first > 10) return;

        if(cur.size() == k && sum == n){
            solution.add(new ArrayList<>(cur));
            return;
        }

        if(sum > n){
            return;
        }

        if(cur.size() > k){
            return;
        }


        int i = first;
        cur.offer(i);
        backtrack(i+1, cur, solution, k, n, sum+i);
        cur.removeLast();

        backtrack(i+1, cur, solution, k, n, sum);

    }


    public static void main(String[] args) {
        System.out.println(combinationSum3(2,6));
    }


}

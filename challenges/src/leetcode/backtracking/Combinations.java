package leetcode.backtracking;

import java.util.*;

/*
* 77. Combinations
* https://leetcode.com/problems/combinations/
* */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> permutations = new ArrayList<>();

        backtrack(1, n, k, new LinkedList<>(), permutations);

        return permutations;
    }

    private static void backtrack(int start, int n, int k, LinkedList<Integer> curr, List<List<Integer>> permutations){

        if(curr.size() == k){
            permutations.add(new LinkedList<>(curr));
            return;
        }

        for(int i = start; i <= n; i++){
            curr.add(i);
            backtrack(i+1, n, k, curr, permutations);
            curr.removeLast();
        }

    }

}

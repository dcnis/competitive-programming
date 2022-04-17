package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public static List<LinkedList<Character>> printCombinationsPractise(String nums, List<LinkedList<Character>> solution){

        dfs(nums, new LinkedList<>(), solution);

        return solution;

    }

    public static void dfs(String nums, LinkedList<Character> curr, List<LinkedList<Character>> solution){

        if(curr.size() == nums.length()){
            solution.add(new LinkedList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length(); i++){
            if(!curr.contains(nums.charAt(i))){
                // do something
                curr.add(nums.charAt(i));

                // make a recursive call
                dfs(nums, curr, solution);

                // undo it
                curr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<LinkedList<Character>> solutions = printCombinationsPractise("012", new ArrayList<>());
        System.out.println(solutions);
    }


}

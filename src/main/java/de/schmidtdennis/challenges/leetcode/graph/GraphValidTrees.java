package de.schmidtdennis.challenges.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTrees {

    public boolean validTree(int n, int[][] edges) {
        // write your code here

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < n; i ++){
            adjacencyList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }

        int[] visiting = new int[n];

        for(int i = 0; i < n; i++){
            if(!dfs(i, i, visiting, adjacencyList)){
                return false;
            }
        }

        return true;
    }


    private boolean dfs(int i, int parent, int[] visiting, Map<Integer, List<Integer>> adjacencyList){
        if(visiting[i] == -1) return false;
        if(visiting[i] == 1 ) return true;

        // mark node as currently visiting
        visiting[i] = -1;

        for(int child: adjacencyList.get(i)){
            if(child == parent) continue;
            if(!dfs(child, i, visiting, adjacencyList)){
                return false;
            }
        }

        visiting[i] = 1;
        return true;
    }

    public static void main(String[] args) {
        GraphValidTrees program = new GraphValidTrees();
        System.out.print("expected: true ");
        System.out.println("actual: " + program.validTree(5, new int[][]{
                {0,1},
                {0,2},
                {0,3},
                {1,4}
        }));

        System.out.print("expected: false ");
        System.out.println("actual: " + program.validTree(5, new int[][]{
                {0,1},
                {1,2},
                {2,3},
                {1,3},
                {1,4}
        }));

    }

}

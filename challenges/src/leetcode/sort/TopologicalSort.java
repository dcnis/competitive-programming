package leetcode.sort;

import java.util.*;

public class TopologicalSort {

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {

        if(hasACycle(jobs, deps)){
            return new ArrayList<>();
        }

        // build our adjacency list
        Map<Integer, List<Integer>> preReqAdjacencyList = new HashMap<>();
        for(int i = 0 ; i < jobs.size(); i++){
            preReqAdjacencyList.put(jobs.get(i), new ArrayList<>());
        }
        for(int i = 0; i < deps.size(); i++){
            preReqAdjacencyList.get(deps.get(i)[1]).add(deps.get(i)[0]);
        }

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        preReqAdjacencyList.keySet().forEach(node -> {
            if(!visited.contains(node)) {
                dfs(node, preReqAdjacencyList, visited, result);
            }
        });

        return result;
    }

    private static void dfs(Integer node, Map<Integer, List<Integer>> preReqAdjacencyList,
                            Set<Integer> visited, List<Integer> result){

        if(visited.contains(node)){
            return;
        } else {
            visited.add(node);
        }

        if(preReqAdjacencyList.get(node).isEmpty()){
            result.add(node);
            return;
        }

        for(Integer i : preReqAdjacencyList.get(node)){
            dfs(i, preReqAdjacencyList, visited, result);
        }

        result.add(node);
    }

    private static boolean hasACycle(List<Integer> jobs, List<Integer[]> deps){
        // build our adjacency list
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < jobs.size(); i++){
            adjacencyList.put(jobs.get(i), new ArrayList<>());
        }
        for(int i = 0; i < deps.size(); i++){
            adjacencyList.get(deps.get(i)[0]).add(deps.get(i)[1]);
        }

        boolean hasCycle = false;
        for(int i = 0; i < jobs.size(); i++){
            boolean[] visited = new boolean[jobs.size()+1];
            hasCycle = dfsCycleCheck(jobs.get(i), visited, adjacencyList);
        }

        return hasCycle;
    }

    private static boolean dfsCycleCheck(Integer node, boolean[] visited, Map<Integer, List<Integer>> adjacencyList){

        if(visited[node]){
            return true; // cycle
        }

        visited[node] = true;

        for(int neighbour : adjacencyList.get(node)){
            boolean isCycle = dfsCycleCheck(neighbour, visited, adjacencyList);
            if(isCycle) return true;
        }

        visited[node] = false; // leetcode.backtracking

        return false;
    }

    public static void main(String[] args) {

        List<Integer> jobs = Arrays.asList(1,2,3,4);
        List<Integer[]> deps = Arrays.asList(
                new Integer[]{1,2},
                new Integer[]{1, 3},
                new Integer[]{3, 2},
                new Integer[]{4, 2},
                new Integer[]{4, 3}
                );

        // should return [1, 4, 3, 2]
        System.out.println(topologicalSort(jobs, deps));

        jobs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        deps = Arrays.asList(
                new Integer[]{1,2},
                new Integer[]{2, 3},
                new Integer[]{3, 4},
                new Integer[]{4, 5},
                new Integer[]{5, 6},
                new Integer[]{6, 7},
                new Integer[]{7, 8},
                new Integer[]{8, 1}
        );
        // should return [] because "isValidTopologicalOrder": false
        System.out.println(topologicalSort(jobs, deps));


    }

}

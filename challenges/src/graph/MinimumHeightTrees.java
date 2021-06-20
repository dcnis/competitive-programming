package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumHeightTrees {


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i ++){
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        while(n > 2){
            n = stripOff(n, map);
        }

        List<Integer> solution = map.keySet().stream().collect(Collectors.toList());

        return solution;
    }

    private int stripOff(int n, Map<Integer, List<Integer>> map){

        List<Integer> keysToRemove = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() == 1){
                keysToRemove.add(entry.getKey());
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            entry.getValue().removeAll(keysToRemove);
        }

        for(Integer key : keysToRemove){
            map.remove(key);
        }

        return n-keysToRemove.size();
    }
    public static void main(String[] args) {
        MinimumHeightTrees program = new MinimumHeightTrees();
        System.out.print("expected: [1]");
        System.out.println(" actual: " + program.findMinHeightTrees(4, new int[][]{
                {1,0},
                {1,2},
                {1,3}
        }));

        System.out.print("expected: [3,4]");
        System.out.println(" actual: " + program.findMinHeightTrees(6, new int[][]{
                {3,0},
                {3,1},
                {3,2},
                {3,4},
                {5,4}
        }));

        System.out.print("expected: [3]");
        System.out.println(" actual: " + program.findMinHeightTrees(6, new int[][]{
                {0,1},
                {0,2},
                {0,3},
                {3,4},
                {4,5}
        }));

    }
}

package graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class OpenLock {
    public static int openLock(String[] _deadends, String target) {

        List<String> deadends = new ArrayList<>();
        for(int i = 0; i < _deadends.length; i++){
            deadends.add(_deadends[i]);
        }

        if(deadends.contains("0000")) return -1;

        // construct the adjacencyList
        Map<String, List<String>> adjacencyList = new LinkedHashMap<>();
        for(int i = 0; i < 10000; i++){
            // create the key
            String key = String.format("%04d", Integer.valueOf(i));
            adjacencyList.put(key, new ArrayList<>());

            addOneToStringAtNthPosition(adjacencyList, key, 0);
            addOneToStringAtNthPosition(adjacencyList, key, 1);
            addOneToStringAtNthPosition(adjacencyList, key, 2);
            addOneToStringAtNthPosition(adjacencyList, key, 3);

            substractOneToStringAtNthPosition(adjacencyList, key, 0);
            substractOneToStringAtNthPosition(adjacencyList, key, 1);
            substractOneToStringAtNthPosition(adjacencyList, key, 2);
            substractOneToStringAtNthPosition(adjacencyList, key, 3);
        }

        // use BFS to find the shortest path of the unweighted graph
        // use BFS to find the shortest path of the unweighted graph
        String[] parents = bfs(adjacencyList, target, deadends);

        if(parents == null){
            return -1;
        }

        int shortestPath = constructShortestPath(parents, target);

        return shortestPath;
    }

    private static int constructShortestPath(String[] parents, String target) {

        int steps = 0;

        String currentNode = target;
        while(!currentNode.equals("0000")){
            steps++;
            currentNode = parents[Integer.valueOf(currentNode)];
        }

        return steps;
    }

    private static String[] bfs(Map<String, List<String>> adjacencyList, String target, List<String> deadends){

        Queue<String> queue = new LinkedList<>();
        boolean found = false;

        boolean[] visited = new boolean[10000];
        queue.offer("0000");
        visited[0] = true;

        String[] parents = new String[10000];

        WHILE: while(!queue.isEmpty()){

            String currentKey = queue.poll();

            List<String> adjacents = adjacencyList.get(currentKey);

            for(int i = 0; i < adjacents.size(); i++){

                int nodesIntValue = Integer.valueOf(adjacents.get(i));

                if(adjacents.get(i).equals(target)){
                    parents[nodesIntValue] = currentKey;
                    found = true;
                    break WHILE;
                }

                if(!visited[nodesIntValue] && !deadends.contains(adjacents.get(i))){
                    queue.offer(adjacents.get(i));
                    visited[nodesIntValue] = true;
                    parents[nodesIntValue] = currentKey;
                }
            }
        }

        return found ? parents: null;

    }

    private static void addOneToStringAtNthPosition(Map<String, List<String>> adjacencyList,
                                                    String key, int position){

        List<String> adjacents = adjacencyList.get(key);

        StringBuilder sb = new StringBuilder(key);

        if(key.charAt(position) == '9'){
            sb.replace(position, position+1, "0");
        } else {
            Integer newValue = Integer.valueOf(key.substring(position, position+1)) + 1;
            sb.replace(position, position+1, newValue.toString());
        }

        adjacents.add(sb.toString());
    }

    private static void substractOneToStringAtNthPosition(Map<String, List<String>> adjacencyList,
                                                          String key, int position){

        List<String> adjacents = adjacencyList.get(key);

        StringBuilder sb = new StringBuilder(key);

        if(key.charAt(position) == '0'){
            sb.replace(position, position+1, "9");
        } else {
            Integer newValue = Integer.valueOf(key.substring(position, position+1)) - 1;
            sb.replace(position, position+1, newValue.toString());
        }

        adjacents.add(sb.toString());
    }

    public static void main(String[] args) {

        // should return -1
        String[] deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        System.out.println(openLock(deadends, "8888"));

        // should return 8
        deadends = new String[]{"0000"};
        System.out.println(openLock(deadends, "8888"));

    }

}

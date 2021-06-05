package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DijkstrasAlgorithmWithArray {

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        // Write your code here.

        int[] shortestPath = new int[edges.length];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[start] = 0;

        Set<Integer> visited = new HashSet<>();

        while(visited.size() < shortestPath.length){
            int currentNode = getNodeWithSmallestDistance(shortestPath, visited);

            if(shortestPath[currentNode] == Integer.MAX_VALUE){
                break;
            }

            visited.add(currentNode);

            for(int i = 0; i < edges[currentNode].length; i++){
                // If already visited, there is no shorter path to this vertex
                int nextVertex = edges[currentNode][i][0];
                int distanceToNextVertex = edges[currentNode][i][1];

                if(visited.contains(nextVertex)){
                    continue;
                }

                // Otherwise check, if the new distance is shorter than the old distance
                int possibleDistance = shortestPath[currentNode] + distanceToNextVertex;
                if(possibleDistance < shortestPath[nextVertex]){
                    shortestPath[nextVertex] = possibleDistance;
                }

            }
        }

        for(int i = 0; i < shortestPath.length; i++){
            if(shortestPath[i] == Integer.MAX_VALUE){
                shortestPath[i] = -1;
            }
        }

        return shortestPath;
    }

    private int getNodeWithSmallestDistance(int[] shortestPath, Set<Integer> visited){

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i = 0; i < shortestPath.length; i++){
            if(visited.contains(i)){
                continue;
            }

            if(shortestPath[i] <= min){
                min = shortestPath[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {

        DijkstrasAlgorithmWithArray program = new DijkstrasAlgorithmWithArray();

        int[][][] edges = new int[5][][];

        edges[0] = new int[1][2];
        edges[1] = new int[1][2];
        edges[2] = new int[2][2];
        edges[3] = new int[1][2];

        edges[0][0][0] = 2;
        edges[0][0][1] = 4;

        edges[1][0][0] = 0;
        edges[1][0][1] = 2;

        edges[2][0][0] = 1;
        edges[2][0][1] = 1;
        edges[2][1][0] = 3;
        edges[2][1][1] = 2;

        edges[3][0][0] = 0;
        edges[3][0][1] = 3;

        int[] answer = program.dijkstrasAlgorithm(0, edges);
        System.out.println(Arrays.toString(answer));

    }

}

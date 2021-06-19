package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfConnectedComponentsInUndirectedGraph {

    int V;
    ArrayList<ArrayList<Integer>> adjListArray;

    NumberOfConnectedComponentsInUndirectedGraph(int V) {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new ArrayList<>();

        // Create a new list for each vertex
        // such that adjacent nodes can be stored

        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<>());
        }
    }



    // Adds an edge to an undirected graph
    void addEdge(int src, int dest) {
        // Add an edge from src to dest.
        adjListArray.get(src).add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray.get(dest).add(src);
    }

    public int getConnectedComponents() {

        int numberOfConnectedComponents = 0;

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < adjListArray.size(); i++) {
            if (visited.contains(i)) {
                continue;
            }
            dfs(i, visited);
            numberOfConnectedComponents++;
        }


        return numberOfConnectedComponents;
    }

    public void printConnectedCoponents(){

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < adjListArray.size(); i++) {
            if (visited.contains(i)) {
                continue;
            }
            dfsPrint(i, visited);
            System.out.println();
        }
    }

    private void dfs(int node, Set<Integer> visited) {
        visited.add(node);

        for (Integer child : adjListArray.get(node)) {
            if (visited.contains(child)) {
                continue;
            }
            dfs(child, visited);
        }
    }

    private void dfsPrint(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node);

        for (Integer child : adjListArray.get(node)) {
            if (visited.contains(child)) {
                continue;
            }
            dfsPrint(child, visited);
        }
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        NumberOfConnectedComponentsInUndirectedGraph g = new NumberOfConnectedComponentsInUndirectedGraph(5); // 5 vertices numbered from 0 to 4

        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println("Number of connected components");
        System.out.println(g.getConnectedComponents()); // should output 2
        g.printConnectedCoponents();

    }

}

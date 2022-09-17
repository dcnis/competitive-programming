package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(node.neighbors == null || node.neighbors.isEmpty()) return new Node(node.val);

        Map<Integer, Node> visited = new HashMap<>();

        dfs(node, visited);

        return visited.get(node.val);
    }

    // 1 [2, 4]
    // 2 [3, 1]
    // 3 [4, 2]
    // 4 [1, 3]

    private void dfs(Node node, Map<Integer, Node> visited){

        visited.put(node.val, new Node(node.val));

        for(Node n : node.neighbors){
            if(!visited.containsKey(n.val)){
                dfs(n, visited);
            }
            visited.get(node.val).neighbors.add(visited.get(n.val));
        }

    }

}

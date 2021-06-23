package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class ListOfDepth {

    public static void main(String[] args) {

        ListOfDepth program = new ListOfDepth();
        // Should output true
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        System.out.print("expected: true");
        System.out.println(" -> actual: " + program.getListOfDepth(root));
    }

    public List<List<Integer>> getListOfDepth(Node root) {

        TreeMap<Integer, List<Node>> depths = new TreeMap<>();

        Queue<Node> q = new LinkedList<>();
        root.level = 0;
        depths.put(0, List.of(root));
        q.offer(root);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.left != null) {
                node.left.level = node.level + 1;
                depths.putIfAbsent(node.level + 1, new ArrayList<>());
                depths.get(node.level + 1).add(node.left);
                q.offer(node.left);
            }
            if (node.right != null) {
                node.right.level = node.level + 1;
                depths.putIfAbsent(node.level + 1, new ArrayList<>());
                depths.get(node.level + 1).add(node.right);
                q.offer(node.right);
            }
        }

        List<List<Integer>> solution = new ArrayList<>();
        depths.values().forEach(row -> {
            List<Integer> list = new ArrayList<>();
            for(Node node : row){
                list.add(node.value);
            }
            solution.add(list);
        });


        return solution;
    }

    static class Node {
        int value;
        Node left;
        Node right;
        int level;

        public Node(int value) {
            this.value = value;
        }
    }

}

package de.schmidtdennis.challenges.leetcode.graph;

import java.util.*;

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

        System.out.println("[[0], [1, 4], [2, 3, 5, 6]] = expected");
        System.out.println(program.getListOfDepth(root) + " = actual");
        System.out.println();
        System.out.println("[[0], [1, 4], [2, 3, 5, 6]] = expected");
        System.out.println(program.getListOfDepthSolution2(root) + " = actual");
    }

    public List<List<Integer>> getListOfDepth(Node root) {

        TreeMap<Integer, List<Node>> depths = new TreeMap<>();

        Queue<Node> q = new LinkedList<>();
        root.level = 0;
        depths.put(0, Arrays.asList(root));
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

    public List<List<Integer>> getListOfDepthSolution2(Node root) {

        List<LinkedList<Node>> solution = new ArrayList<>();

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            solution.add(queue);
            LinkedList<Node> parents = queue;
            queue = new LinkedList<>();

            for(Node node : parents){
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        solution.forEach(row ->{
            List<Integer> list = new ArrayList<>();
            for(Node node: row){
                list.add(node.value);
            }
            result.add(list);
        });

        return result;
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

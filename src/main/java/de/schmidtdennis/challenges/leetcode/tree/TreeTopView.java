package de.schmidtdennis.challenges.leetcode.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TreeTopView {

    enum TreeSide{
        LEFT,
        RIGHT
    }

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static Map<Node, Integer> nodeHeights = new HashMap<>();
    private static Map<Node, Integer> nodeDistances = new HashMap<>();
    private static Map<Node, List<Integer>> nodesWithData = new LinkedHashMap<>();

    public static void topView(Node root) {

        // Get the height of every single node
        dfsSetHeights(root, 0);

        // Get the distance of every single node
        nodeDistances.put(root, 0);
        if(root.left != null){
            dfsSetDistance(root.left, -1, TreeSide.LEFT);
        }
        if(root.right != null){
            dfsSetDistance(root.right, 1, TreeSide.RIGHT);
        }

        // Put all data into a map
        dfsSetAllData(root);

        // Delete hidden nodes
        deleteHiddenNodes();

        // print the list of remaining nodes
        printRemainingNodes();

    }

    private static void printRemainingNodes(){

        List<String> nodesData = new ArrayList<>();

        Comparator<List<Integer>> compareByDistance = Comparator.comparing((List<Integer> nodeWithData) -> nodeWithData.get(1));

        nodesWithData.keySet().stream()
                .filter(key -> nodesWithData.get(key) != null)
                .sorted(Comparator.comparing((Node node) -> nodesWithData.get(node).get(1)))
                .map(key -> String.valueOf(key.data))
                .forEach(nodesData::add);

        for(int i = 0; i < nodesData.size()-1; i++){
            System.out.print(nodesData.get(i) + " ");
        }
        System.out.println(nodesData.get(nodesData.size()-1));
    }

    private static void deleteHiddenNodes(){
        // Run through the LinkedHashMap and delete all hidden nodes

        nodesWithData.keySet().forEach(key -> {
            if(nodesWithData.get(key) != null){
                removeNodes(nodesWithData.get(key).get(0)+1, nodesWithData.get(key).get(1));
            }
        });

    }

    private static void removeNodes(int minLevel, int distance){

        nodesWithData.keySet().forEach(key -> {

            if(nodesWithData.get(key) != null){
                if(nodesWithData.get(key).get(0) >= minLevel && nodesWithData.get(key).get(1) == distance){
                    nodesWithData.put(key, null);
                }
            }
        });

    }

    private static void dfsSetAllData(Node node){
        if(node == null) return;

        List<Integer> nodeData = new ArrayList<>();
        nodeData.add(nodeHeights.get(node));
        nodeData.add(nodeDistances.get(node));
        nodesWithData.put(node, nodeData);

        dfsSetAllData(node.left);
        dfsSetAllData(node.right);
    }

    private static void dfsSetDistance(Node node, int distance, TreeSide side){
        if(node == null){
            return;
        }

        if(side == TreeSide.LEFT){
            dfsSetDistance(node.left, distance-1, side);
            dfsSetDistance(node.right, distance+1, side);
        } else {
            dfsSetDistance(node.left, distance-1, side);
            dfsSetDistance(node.right, distance+1, side);
        }

        nodeDistances.put(node, distance);
    }

    private static void dfsSetHeights(Node node, int height){

        if(node == null) return;

        dfsSetHeights(node.left, height+1);
        dfsSetHeights(node.right, height+1);

        nodeHeights.put(node, height);
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(6);
        root.right.right = new Node(7);

        root.left.right = new Node(3);
        root.left.right.left = new Node(4);
        root.left.right.left.left = new Node(5);

        topView(root);
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        Node root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        scan.close();
//        topView(root);
    }

}

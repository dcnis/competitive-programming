package de.schmidtdennis.challenges.leetcode.tree;

public class DistanceFromRootOfAnyGivenNode {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }


    private int getDistanceFromRoot(Node root, int value){

        if(root.value == value) return 0;

        int dfsLeft = 0;
        int dfsRight = 0;

        if(root.left != null){
            dfsLeft = dfsLeft(root.left, value, 1);
        }

        if(root.right != null){
            dfsRight = dfsRight(root.right, value, 1);
        }

        if(dfsLeft != 0){
            dfsLeft *= (-1);
            return dfsLeft;
        } else {
            return dfsRight;
        }
    }

    private int dfsLeft(Node node, int value, int distance){

        if(node == null) return 0;

        if(node.value == value) return distance;

        int leftDistance = dfsLeft(node.left, value, distance+1);
        int rightDistance = dfsLeft(node.right, value, distance-1);

        return Math.max(leftDistance, rightDistance);
    }

    private int dfsRight(Node node, int value, int distance){

        if(node == null) return 0;

        if(node.value == value) return distance;

        int leftDistance = dfsRight(node.left, value, distance-1);
        int rightDistance = dfsRight(node.right, value, distance+1);

        return Math.max(leftDistance, rightDistance);
    }

    public static void main(String[] args) {
        DistanceFromRootOfAnyGivenNode program = new DistanceFromRootOfAnyGivenNode();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);

        root.left.right = new Node(3);
        root.left.right.left = new Node(4);
        root.left.right.left.left = new Node(5);

        System.out.println(program.getDistanceFromRoot(root, 8));
    }


}

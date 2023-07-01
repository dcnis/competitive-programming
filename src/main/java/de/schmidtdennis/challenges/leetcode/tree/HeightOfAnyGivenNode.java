package de.schmidtdennis.challenges.leetcode.tree;

public class HeightOfAnyGivenNode {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private int findHeight(Node root, int value){

        if(root.value == value) return 0;

        int height = dfs(root, value, 0);

        if(height == 0) return -1;

        return height;
    }

    private int dfs(Node node, int value, int height){

        if(node == null){
            return 0;
        }

        if(node.value == value){
            return height;
        }

        int leftHeight = dfs(node.left, value, height+1);
        int rightHeight = dfs(node.right, value, height+1);

        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        HeightOfAnyGivenNode program = new HeightOfAnyGivenNode();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(6);

        root.right.right = new Node(7);

        root.left.right = new Node(3);
        root.left.right.left = new Node(4);
        root.left.right.left.left = new Node(5);
        System.out.println(program.findHeight(root, 7));
    }



}

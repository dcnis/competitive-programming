package leetcode.tree;

import java.util.Scanner;

public class BinarySearchTreeInsertion {


    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

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

    public static Node insert(Node root,int data) {

        if(root == null ) return new Node(data);

        insertNode(root, data);

        return root;
    }

    private static void insertNode(Node node, int data){

        if(data > node.data){
            if(node.right == null){
                node.right = new Node(data);
                return;
            } else {
                insertNode(node.right, data);
            }
        } else {
            if(node.left == null){
                node.left = new Node(data);
                return;
            } else {
                insertNode(node.left, data);
            }
        }

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);

    }
}

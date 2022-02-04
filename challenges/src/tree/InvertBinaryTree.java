package tree;

import java.util.Deque;
import java.util.LinkedList;

public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.

        if(tree == null) return;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);

        // swap left child and right child
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }

    public static BinaryTree invertBinaryTree2(BinaryTree node) {
        if(node == null) return null;
        if(node.left == null && node.right == null) return node;

        BinaryTree left = invertBinaryTree2(node.left);
        BinaryTree right = invertBinaryTree2(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    public static BinaryTree invertBinaryTreeIteratively(BinaryTree node) {

        if(node == null) return null;
        if(node.left == null && node.right == null) return node;

        Deque<BinaryTree> stack = new LinkedList<>();
        stack.push(node);

        while(!stack.isEmpty()){

            BinaryTree currNode = stack.pop();
            if(currNode.left != null){
                stack.push(currNode.left);
            }

            if(currNode.right != null){
                stack.push(currNode.right);
            }


            BinaryTree temp = currNode.left;
            currNode.left = currNode.right;
            currNode.right = temp;


        }

        return node;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(3);
        root.right = new BinaryTree(2);

        BinaryTree root2 = invertBinaryTree2(root);
        System.out.println(root2);


    }

}

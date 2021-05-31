package tree;

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

        invertBinaryTree(root);
        System.out.println(root);
    }

}

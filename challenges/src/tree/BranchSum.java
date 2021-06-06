package tree;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();

        dfs(root, 0, result);

        return result;
    }

    private static void dfs(BinaryTree node, int sum, List<Integer> result){
        if(node.left == null && node.right == null){
            result.add(sum + node.value);
        }

        if(node.left != null){
            dfs(node.left, sum + node.value, result);
        }

        if(node.right != null){
            dfs(node.right, sum + node.value, result);
        }

    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(5);
        root.left.right = new BinaryTree(6);
        root.right = new BinaryTree(7);
        System.out.println(branchSums(root)); // should output [8, 9, 8]
    }
}

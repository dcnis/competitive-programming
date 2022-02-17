package leetcode.tree;

import java.util.Stack;

/*
235. Lowest Common Ancestor of a Binary Search Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
*
 */
public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Improved second Solution interavely
    public TreeNode lowestCommonAncestorSecondSolutionIteravely(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);


        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            // Both are in the left subtree
            if(p.val < node.val && q.val < node.val){
                stack.push(node.left);
            } else if(p.val > node.val && q.val > node.val){
                stack.push(node.right);
            } else {
                return node;
            }

        }

        return null;
    }

    // Improved second Solution
    public TreeNode lowestCommonAncestorSecondSolution(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        // Both are in the left subtree
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestorSecondSolution(root.left, p,q);
        }

        // Both are in the right subtree
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestorSecondSolution(root.right, p,q);
        }

        return root;
    }


    // Complicated Solution
    public TreeNode lowestCommonAncestorFirstSolution(TreeNode root, TreeNode p, TreeNode q) {


        if (root == null) return null;

        TreeNode left = lowestCommonAncestorFirstSolution(root.left, p, q);
        TreeNode right = lowestCommonAncestorFirstSolution(root.right, p, q);

        if (left == null && right == null && root.val != p.val && root.val != q.val) return null;

        // I am the lca
        if (left == null && right != null && (root.val == p.val || root.val == q.val)) return root;

        // I am the lca
        if (left != null && right == null && (root.val == p.val || root.val == q.val)) return root;

        if (left != null && right == null) return left;
        if (right != null && left == null) return right;
        if (right != null && left != null) return root;
        if (root.val == p.val || root.val == q.val) return root;

        return null;
    }
}

package de.schmidtdennis.challenges.leetcode.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
* 98. Validate Binary Search Tree
* https://leetcode.com/problems/validate-binary-search-tree/
* */

public class ValidateBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /* Solution with PriorityQueue */
    public boolean isValidBSTWithPQ(TreeNode root) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        return dfs(root, pq);

    }
    private boolean dfs(TreeNode root, PriorityQueue<Integer> pq){

        if(root == null) return true;

        if(!pq.isEmpty() && pq.peek() >= root.val) return false;

        if(root.left == null && root.right == null) {
            pq.offer(root.val);
            return true;
        }

        boolean left = dfs(root.left, pq);

        if(!pq.isEmpty() && root.val <= pq.peek()) return false;

        pq.offer(root.val);

        boolean right = dfs(root.right, pq);

        return  left && right;
    }



    // Solution with Upper and Lower Limit
    public boolean isValidBSTWithLimits(TreeNode root) {

        return isValidLimits(root, null, null);

    }
    private boolean isValidLimits(TreeNode root, Integer low, Integer high){

        if(root == null) return true;

        List<Integer> list = new ArrayList<>();
        list.stream().mapToInt(x->x).toArray();
        if(low != null && root.val <= low || high != null && root.val >= high) return false;
        return isValidLimits(root.left, low, root.val) && isValidLimits(root.right, root.val, high);
    }

}

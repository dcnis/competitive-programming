package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
*   116. Populating Next Right Pointers in Each Node
*   https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
* */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointer {

    public Node connectVersion2(Node root){
        if(root == null) return null;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        while(!q.isEmpty()){

            Node node = q.poll();

            if(node == null){
                if(!q.isEmpty()){
                    q.offer(null);
                }
            } else {

                if(q.peek() != null){
                    node.next = q.peek();
                }

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }
            }

        }

        return root;
    }
    public Node connectVersion1(Node root) {

        if(root == null) return null;

        Queue<Node> q = new LinkedList<>();
        Queue<Node> nodes = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            Node node = q.poll();

            nodes.offer(node);

            if(node.left != null){
                q.offer(node.left);
            }

            if(node.right != null){
                q.offer(node.right);
            }
        }

        // delete root
        q.poll();

        while(nodes.size() > 1){
            Node one = nodes.poll();
            Node two = nodes.poll();

            one.left.next = one.right;
            one.right.next = two.left;

            two.left.next = two.right;

        }

        return root;
    }

}

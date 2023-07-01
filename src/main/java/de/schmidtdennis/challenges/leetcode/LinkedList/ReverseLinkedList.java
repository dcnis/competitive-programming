package de.schmidtdennis.challenges.leetcode.LinkedList;

public class ReverseLinkedList {


    static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node reverseLinkedList(Node node){

        Node prev = null;

        while(node != null){

            Node temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;

        }

        return prev;
    }

    public static void main(String[] args) {
        System.out.println("0->1->2->3->4->5->null");
        Node root = new Node(0);
        root.next = new Node(1);
        root.next.next = new Node(2);
        root.next.next.next = new Node(3);
        root.next.next.next.next = new Node(4);
        root.next.next.next.next.next = new Node(5);

        Node newHead = reverseLinkedList(root);

        System.out.println(newHead.value + "->" +
                newHead.next.value + "->" +
                newHead.next.next.value + "->" +
                newHead.next.next.next.value + "->" +
                newHead.next.next.next.next.value + "->" +
                newHead.next.next.next.next.next.value + "->" + null);
    }


}

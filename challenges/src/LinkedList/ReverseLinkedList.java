package LinkedList;

public class ReverseLinkedList {


    static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node reverseLinkedList(Node head){

        Node p1 = null;
        Node p2 = head;
        Node p3 = head;

        while(p2 != null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        return p1;
    }

    public static void main(String[] args) {
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

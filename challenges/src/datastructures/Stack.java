package datastructures;

public class Stack {

    Node head;
    int currentSize;

    public Stack(){
        this.currentSize = 0;
    }

    class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }

    }

    public void push(int value){
        Node newNode = new Node(value);

        currentSize++;
        if(head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public Integer pop(){
        if(head == null) return null;

        int returnValue = head.value;
        head = head.next;
        currentSize--;
        return returnValue;
    }

    public Integer peek(){
        if(head == null) return null;

        return head.value;
    }

    public int size(){
        return currentSize;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }



}

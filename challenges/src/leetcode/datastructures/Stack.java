package leetcode.datastructures;


public class Stack<T> {

    Node head;
    int currentSize;

    public Stack(){
        this.currentSize = 0;
    }

    class Node {
        T value;
        Node next;

        public Node(T value){
            this.value = value;
        }

    }

    public void push(T value){
        Node newNode = new Node(value);

        currentSize++;
        if(head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public T pop(){
        if(head == null) return null;

        T returnValue = head.value;
        head = head.next;
        currentSize--;
        return returnValue;
    }

    public T peek(){
        if(head == null) return null;

        return head.value;
    }

    public int size(){
        return currentSize;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
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

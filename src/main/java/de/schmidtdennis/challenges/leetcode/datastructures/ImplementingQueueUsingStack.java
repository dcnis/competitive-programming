package de.schmidtdennis.challenges.leetcode.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementingQueueUsingStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> memory;

    public ImplementingQueueUsingStack() {
        stack = new LinkedList<>();
        memory = new LinkedList<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
        } else {
            // save data to memory
            while(!stack.isEmpty()){
                memory.push(stack.pop());
            }

            // push new value to top
            stack.push(x);

            // add old data back on top of stack
            while(!memory.isEmpty()){
                stack.push(memory.pop());
            }

        }
    }

    public Integer pop() {
        return !stack.isEmpty() ? stack.pop() : null;
    }

    public Integer peek() {
        return !stack.isEmpty() ? stack.peek() : null;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ImplementingQueueUsingStack q = new ImplementingQueueUsingStack();
        q.push(1);
        q.push(2);
        System.out.println(q.peek()); // 1
        System.out.println(q.pop()); // 1
        System.out.println(q.empty()); // false
        System.out.println(q.pop()); // 2
    }

}

package de.schmidtdennis.challenges.leetcode.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Map<Integer, Node> cache;
    private Node first;
    private Node last;

    public LRUCache(int capacity){
        this.capacity=capacity;
        this.size = 0;
        this.cache = new HashMap<>(capacity);
        this.first = new Node(-1, -1);
        this.last = new Node(-1, -1);
        this.first.prev = this.last;
        this.last.next = this.first;
    }

    public void put(int key, int value){

        Node exist = cache.get(key);
        if(exist != null){
            cache.remove(key);
            remove(exist);
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        add(node);

        if(size > capacity){
            cache.remove(last.next.key);
            remove(last.next);
        }

    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    private void add(Node node){
        Node tmp = first.prev;
        first.prev.next = node;
        first.prev = node;
        node.next = first;
        node.prev = tmp;
        size++;
    }

    public int get(int key){
        Node node = cache.get(key);

        if(node == null) return -1;

        // put node to the beginning of the LinkedList
        remove(node);
        add(node);

        return node.value;
    }

}

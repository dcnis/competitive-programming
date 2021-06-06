package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LRUCache {

    int currentSize;
    int maxSize;
    Map<String, Node> cache = new HashMap<>();
    Node head;
    Node tail;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize > 1 ? maxSize : 1;
    }



    public void insertKeyValuePair(String key, int value) {
        // Write your code here.
        if (currentSize < maxSize) {
            // just add it
            Node node = new Node(value, key);
            if (cache.containsKey(key)) {
                // just update the value and bubble up
                if (cache.get(key) != head) {
                    this.updateValueAndSetItAsHead(key, value);
                } else {
                    // just update the value because its already the head
                    cache.get(key).value = value;
                }


            } else {
                // add it to the cache
                cache.put(key, node);
                currentSize++;

                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    node.next = head;
                    head.prev = node;
                    head = node;
                }
            }
        } else {
            // add it and remove the last
            if (cache.containsKey(key)) {
                // update it but do NOT evict an item
                if (cache.get(key) != head) {
                    this.updateValueAndSetItAsHead(key, value);
                } else {
                    // just update the value because its already the head
                    cache.get(key).value = value;
                }

            } else {
                // add item and evict the tail
                Node node = new Node(value, key);
                cache.put(key, node);
                currentSize++;

                node.next = head;
                head.prev = node;
                head = node;

                // evict the tail
                cache.remove(tail.key);
                tail.prev.next = null;
                tail = tail.prev;

            }

        }
    }

    private void updateValueAndSetItAsHead(String key, int value) {
        Node currentNode = cache.get(key);
        currentNode.value = value;

        // bubble up
        if (currentNode == tail) {
            currentNode.prev.next = currentNode.next;
            tail = currentNode.prev;
            currentNode.prev = null;
            currentNode.next = head;
            head.prev = currentNode;
            head = currentNode;
            return;
        } else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            currentNode.prev = null;
            currentNode.next = head;
            head.prev = currentNode;
            head = currentNode;
        }

    }

        public LRUResult getValueFromKey(String key) {
            // Write your code here.
            if(!cache.containsKey(key)) {
                return null;
            }

            // return key and bubble up
            Node currentNode = cache.get(key);
            if(head == currentNode){
                // just return the value because node is already the head
                return new LRUResult(true, currentNode.value);
            }

            // make the currentNode as head and return the value
            this.setNodeAsHead(currentNode);

            return new LRUResult(true, currentNode.value);
        }

    public String getMostRecentKey() {
        // Write your code here.
        return head.key;
    }

    private void setNodeAsHead(Node currentNode){
        // bubble up
        if(currentNode == tail){
            currentNode.prev.next = currentNode.next;
            tail = currentNode.prev;
            currentNode.prev = null;
            currentNode.next = head;
            head.prev = currentNode;
            head = currentNode;
            return;
        } else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            currentNode.prev = null;
            currentNode.next = head;
            head.prev = currentNode;
            head = currentNode;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }

    }

    static class Node {
        int value;
        String key;
        Node next;
        Node prev;

        public Node(int value, String key) {
            this.value = value;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("a", 1);
        lruCache.insertKeyValuePair("c", 3);
        System.out.println(lruCache.getMostRecentKey());
        System.out.println(lruCache.getValueFromKey("a"));
        System.out.println(lruCache.getMostRecentKey());
        lruCache.insertKeyValuePair("d", 4);
        System.out.println(lruCache.getValueFromKey("b"));


    }


}

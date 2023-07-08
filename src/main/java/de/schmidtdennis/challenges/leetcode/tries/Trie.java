package de.schmidtdennis.challenges.leetcode.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
class Trie {

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        public TrieNode(){
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.root;

        for(Character c : word.toCharArray()) {
            TrieNode letter = node.children.get(c);
            if(letter == null){
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode lastNode = getLastNodeOfPrefix(word);
        return lastNode != null && lastNode.isWord;
    }

    public boolean startsWith(String prefix) {
        return getLastNodeOfPrefix(prefix) != null;
    }

    public TrieNode getLastNodeOfPrefix(String prefix){
        TrieNode node = this.root;

        for(Character c : prefix.toCharArray()){
            TrieNode letter = node.children.get(c);
            if(letter == null) return null;
            node = letter;
        }

        return node;
    }

}

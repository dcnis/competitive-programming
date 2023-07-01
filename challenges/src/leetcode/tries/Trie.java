package leetcode.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {
    private Map<Character, Trie> children;
    private boolean isWord;

    public Trie() {
        this.children = new HashMap<>();
        isWord = false;
    }

    public void insert(String word) {
        // find the first character
        Trie node = this;
        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            // if children do not have current character -> insert it
            Trie child = node.children.get(c);
            if(child == null){
                node.children.put(c, new Trie());
            }
            node =  node.children.get(c);
        }
        node.isWord=true;
    }

    private Trie searchPrefix(String prefix){
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++){
            Character c = prefix.charAt(i);
            Trie child = node.children.get(c);
            if(child == null){
                return null;
            }
            node = child;
        }

        return node;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
        t.insert("app");
        System.out.println(t.search("app"));
    }
}

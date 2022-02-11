package leetcode.tries;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTree{
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTree(String str){
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            // Write your code here.
            for(int i = 0; i < str.length(); i++){
                TrieNode currentNode = root;
                for(int j = i; j < str.length(); j++){
                    if(!currentNode.children.containsKey(str.charAt(j))){
                        currentNode.children.put(str.charAt(j), new TrieNode());
                    }
                    currentNode = currentNode.children.get(str.charAt(j));
                }
                currentNode.children.put(endSymbol, null);
            }
        }

        public boolean contains(String str) {
            // Write your code here.
            TrieNode currentNode = root;
            for(int i = 0; i < str.length(); i++){
                if(!currentNode.children.containsKey(str.charAt(i))){
                    return false;
                } else {
                    currentNode = currentNode.children.get(str.charAt(i));
                }
            }

            return currentNode.children.containsKey(endSymbol);
        }

    }

    public static void main(String[] args) {
        SuffixTree program = new SuffixTree("babc");
        System.out.print("expected : true");
        System.out.println(" actual: " + program.contains("abc"));
    }

}

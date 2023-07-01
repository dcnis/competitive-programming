package leetcode.tries;

import leetcode.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearchII {
    class TrieNode {
        Map<Character, TrieNode> children;
        String word;

        public TrieNode(){
            this.children = new HashMap<>();
            this.word = null;
        }
    }

    class Trie {

        TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }

        public void insert(String word){
            TrieNode node = root;

            for(int i = 0; i < word.length(); i++){
                Character c = word.charAt(i);
                TrieNode child = node.children.get(c);
                if(child == null){
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.word = word;
        }

        public TrieNode hasPrefix(String prefix){
            TrieNode node = root;

            for(int i = 0; i < prefix.length(); i++){
                Character c = prefix.charAt(i);
                TrieNode child = node.children.get(c);
                if(child == null) return null;
                node = child;
            }

            return node;
        }

    }



    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        Set<String> answ = new HashSet<>();

        // First build a trie
        Trie trie = buildTrie(words);

        // dfs through matrix and for each sell start a searchWord();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                Character c = board[i][j];
                if(trie.root.children.containsKey(c)){
                    dfs(i, j, board, new int[m][n], trie.root, answ);
                }

            }
        }

        return new ArrayList<>(answ);
    }

    private void dfs(int i, int j, char[][] board, int[][] visited, TrieNode parent, Set<String> answ){
        if(i < 0 || i >= board.length){
            return;
        }

        if(j < 0 || j >= board[0].length){
            return;
        }

        if(visited[i][j] == 1){
            return;
        }

        Character c = board[i][j];
        TrieNode currentNode = parent.children.get(c);
        if(currentNode == null) return;

        if(currentNode.word != null){
            answ.add(currentNode.word);
        }

        visited[i][j] = 1;


        // down
        dfs(i+1, j, board, visited, currentNode, answ);

        // left
        dfs(i, j-1, board, visited, currentNode, answ);

        // up
        dfs(i-1, j, board, visited, currentNode, answ);

        // right
        dfs(i, j+1, board, visited, currentNode, answ);

        visited[i][j] = 0;

    }

    private Trie buildTrie(String[] words){

        Trie trie = new Trie();

        for(String word : words){
            trie.insert(word);
        }

        return trie;
    }

    public static void main(String[] args) {
        WordSearchII code = new WordSearchII();
        String[] words = Utils.readStringArray("[\"oath\",\"pea\",\"eat\",\"rain\"]");
    }
}

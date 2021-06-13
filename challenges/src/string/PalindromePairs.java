package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PalindromePairs {
    /*Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list,
    so that the concatenation of the two words words[i] + words[j] is a palindrome.

    Input: words = ["bat","tab","cat"]
    Output: [[0,1],[1,0]]
    Explanation: The palindromes are ["battab","tabbat"]

    */

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> solutionPairs = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(words[i] != words[j]){
                    if(isPalindrome(words[i], words[j])){
                        solutionPairs.add(Arrays.asList(i, j));
                    }
                }
            }
        }

        return solutionPairs;
    }

    private boolean isPalindrome(String first, String second){
        StringBuilder sb = new StringBuilder(first);
        sb.append(second);

        int i = 0;
        int j = sb.length()-1;

        while(i < j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {

        PalindromePairs program = new PalindromePairs();
        System.out.println(program.isPalindrome("tab", "bat"));
        StringBuilder sb = new StringBuilder();

    }
}

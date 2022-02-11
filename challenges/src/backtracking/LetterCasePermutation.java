package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 784. Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {

    List<String> permutations = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {

        backtrack(0, s.toCharArray(), new StringBuilder());

        return permutations;
    }

    private void backtrack(int start, char[] str, StringBuilder sb){

        if(sb.length() == str.length){
            permutations.add(sb.toString());
            return;
        }

        if(Character.isLetter(str[start])){
            sb.append(Character.toLowerCase(str[start]));
            backtrack(start+1, str, sb);
            sb.deleteCharAt(sb.length()-1);

            sb.append(Character.toUpperCase(str[start]));
            backtrack(start+1, str, sb);
            sb.deleteCharAt(sb.length()-1);

        } else {
            sb.append(str[start]);
            backtrack(start+1, str, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }

}

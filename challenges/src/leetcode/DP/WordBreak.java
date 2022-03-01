package leetcode.DP;

import java.util.List;

// 139. Word Break
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        int[] memo = new int[s.length()];

        return wordBreakDP(s.toCharArray(), 0, wordDict, memo);
    }


    private boolean wordBreakDP(char[] str, int index, List<String> wordDict, int[] memo){

        if(index >= str.length) return true;

        if(memo[index] != 0) return memo[index] == 1;

        StringBuilder sb = new StringBuilder();

        for(int i = index; i < str.length; i++){
            sb.append(str[i]);

            if(wordDict.contains(sb.toString())){
                boolean temp = wordBreakDP(str, i+1, wordDict, memo);
                if(temp){
                    memo[i] = 1;
                    return true;
                }
            }
        }

        memo[index] = -1;
        return false;

    }

}

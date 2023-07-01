package de.schmidtdennis.challenges.leetcode.string;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {

        int answer = 0;

        for(int i = 0; i < words.length; i++){
            if(isWordSubsequence(s, words[i])) answer++;
        }

        return answer;
    }

    private boolean isWordSubsequence(String s, String word){

        char[] charArray = word.toCharArray();
        int currIndex = 0;

        for(int i=0; i < charArray.length;i++){
            currIndex = s.indexOf(charArray[i], currIndex);
            if(currIndex == -1){
                return false;
            } else {
                currIndex++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NumberOfMatchingSubsequences program = new NumberOfMatchingSubsequences();
        System.out.print("expected: 2 ");
        System.out.println("actual: " + program.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    }
}

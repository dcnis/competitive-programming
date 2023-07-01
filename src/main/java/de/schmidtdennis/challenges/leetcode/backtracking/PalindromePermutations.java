package de.schmidtdennis.challenges.leetcode.backtracking;

import java.util.HashMap;

/**
 * Given a string s, return true if a permutation of the string could form a palindrome.
 */

public class PalindromePermutations {

    public static boolean canPermutePalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int uneven = 0;

        for(Integer val: map.values()){
            if((val%2) > 0) uneven++;
        }

        return uneven < 2;

    }


    public static void main(String[] args) {



    }

    private static boolean isPalindrome(String str){
        if(str.length()==1) return true;

        int i = 0, j=str.length()-1;

        while(i < j){
            if(str.charAt(i) != (str.charAt(j))){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}

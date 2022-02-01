package string;

import java.util.HashSet;
import java.util.Set;

/*
* 3. Longest Substring Without Repeating Characters
* Leetcode Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
* */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("hello")); // 3
        System.out.println(lengthOfLongestSubstring("")); // 0
        System.out.println(lengthOfLongestSubstring("aab")); //2
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.isEmpty()) return 0;

        char[] substring = s.toCharArray();


        int longestSubstringSoFar = Integer.MIN_VALUE;

        for(int i = 0; i < substring.length; i++){
            int k = i;
            Set<Character> set = new HashSet<>();
            int longestSubstring = 0;
            while(k < substring.length){
                if(set.contains(substring[k])){
                    break;
                } else {
                    set.add(substring[k]);
                    longestSubstring++;
                    k++;
                }
            }

            if(longestSubstring > longestSubstringSoFar){
                longestSubstringSoFar = longestSubstring;
            }
        }

        return longestSubstringSoFar;
    }

}

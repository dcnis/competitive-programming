package leetcode.string;

import leetcode.utils.Tag;

import java.util.HashSet;
import java.util.Set;

/*
* 3. Longest Substring Without Repeating Characters
* Leetcode Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
* */
public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        System.out.printf("Tags: %s, %s%n", Tag.SLIDING_WINDOW, Tag.STRINGS);

        System.out.println(lengthOfLongestSubstring("hello")); // 3
        System.out.println(lengthOfLongestSubstring("")); // 0
        System.out.println(lengthOfLongestSubstring("aab")); //2
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.isEmpty()) return 0;

        int i = 0, j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while(i < s.length()){

            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(j));
                j++;
            }

        }

        return max;
    }

}

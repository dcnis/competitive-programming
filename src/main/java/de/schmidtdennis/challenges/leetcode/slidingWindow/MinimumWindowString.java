package de.schmidtdennis.challenges.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowString {

    public static String minWindow(String s, String t) {

        Map<Character, Integer> expected = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < t.length(); i++){
            expected.put(t.charAt(i), expected.getOrDefault(t.charAt(i), 0) + 1);
            set.add(t.charAt(i));
        }

        Map<Character, Integer> cur = new HashMap<>();
        String minimumString = "";

        int j = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++){

            if(set.contains(s.charAt(i))){
                cur.put(s.charAt(i), cur.getOrDefault(s.charAt(i), 0) + 1);
                if(curEnough(cur, expected)){
                    while(!set.contains(s.charAt(j))){
                        j++;
                    }
                    while(curEnough(cur, expected)){
                        cur.put(s.charAt(j), cur.getOrDefault(s.charAt(j), 0) - 1);
                        if(cur.get(s.charAt(j)) < 1){
                            cur.remove(s.charAt(j));
                        }
                        j++;
                    }

                    if((i-j+2) < min){
                        min = i-j+2;
                        minimumString = s.substring(j-1, i+1);
                    }
                }
            }

        }

        return minimumString;

    }


    private static boolean curEnough(Map<Character, Integer> cur, Map<Character, Integer> expected){
        if(cur.keySet().size() != expected.keySet().size()) return false;

        for(Character key : cur.keySet()){
            if(expected.get(key) > cur.get(key)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ab", "b"));
    }

}

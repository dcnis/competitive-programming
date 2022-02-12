package leetcode.string;

import java.util.Deque;
import java.util.LinkedList;

/*
* 20. Valid Parentheses
* https://leetcode.com/problems/valid-parentheses/
* */
public class ValidParanthesis {

    public boolean isValid(String s) {


        Deque<Character> br = new LinkedList<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{'){
                br.push(c);
            } else if( c == ')' && !br.isEmpty() && br.peek() == '('){
                br.pop();
            } else if( c == ']' && !br.isEmpty() && br.peek() == '['){
                br.pop();
            } else if( c == '}' && !br.isEmpty() && br.peek() == '{'){
                br.pop();
            } else {
                return false;
            }
        }

        return br.size() == 0;
    }

}

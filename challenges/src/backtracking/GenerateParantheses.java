package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }


    private void backtrack(List<String> list, String currentString, int open, int closed, int max){
        if(currentString.length() == max*2){
            list.add(currentString);
            return;
        }
        if(open < max) backtrack(list, currentString+"(", open+1, closed, max);
        if(closed < open) backtrack(list, currentString+")", open, closed+1, max);
    }

    public static void main(String[] args) {
        GenerateParantheses program = new GenerateParantheses();
        List<String> result = program.generateParenthesis(3);
        System.out.println(result);
    }

}

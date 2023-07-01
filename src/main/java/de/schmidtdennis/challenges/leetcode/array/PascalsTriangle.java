package de.schmidtdennis.challenges.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            list.add(getListForRow(i));
        }

        return list;
    }


    private List<Integer> getListForRow(int i){

        if(i == 1) return Arrays.asList(1);
        if(i==2) return Arrays.asList(1,1);

        List<Integer> list = new ArrayList<>();
        list.add(1);

        List<Integer> lowerList = getListForRow(i-1);
        for(int j = 0; j < lowerList.size()-1; j++){
            int sum = lowerList.get(j) + lowerList.get(j+1);
            list.add(sum);
        }

        list.add(1);

        return list;

    }

    public static void main(String[] args) {
        PascalsTriangle program = new PascalsTriangle();
        System.out.println(program.generate(5));
    }
}

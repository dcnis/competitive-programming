package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        // Write your code here.
        int result = sumArray(array, 2);
        return result;
    }

    private static int sumArray(List<Object> list, int level){
        int sum = 0;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof Integer){
                sum += (int) list.get(i);
            } else {
                sum += level * sumArray((List<Object>)list.get(i), level+1);
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        List<Object> listOne = List.of(1, 2, 3, 4, 5);
        System.out.println(productSum(listOne)); //should output 15

        List<Object> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(List.of(7, -1));
        list.add(3);
        list.add(List.of(6, List.of(-13, 8), 4));

        System.out.println(productSum(list)); // should output 12
    }
}

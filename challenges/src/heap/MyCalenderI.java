package heap;

import java.util.TreeSet;

public class MyCalenderI {

    TreeSet<int[]> treeSet = new TreeSet<>((a, b) -> a[0]-b[0]);

    public boolean book(int start, int end) {

        int[] entry = new int[]{start, end};

        // getLower and check
        int[] lowerOrSame = treeSet.ceiling(entry);
        if(lowerOrSame != null && entry[0] < lowerOrSame[1] && lowerOrSame[0] < entry[1]){
            return false;
        }

        int[] higherOrSame = treeSet.floor(entry);
        if(higherOrSame != null && entry[0] < higherOrSame[1] && higherOrSame[0] < entry[1]){
            return false;
        }
        treeSet.add(entry);

        return true;

    }

    public static void main(String[] args) {
        MyCalenderI program = new MyCalenderI();

        System.out.println(program.book(10, 20 ));
        System.out.println(program.book(15,25));
        System.out.println(program.book(20, 30));

    }

}

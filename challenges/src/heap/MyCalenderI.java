package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MyCalenderI {

    TreeSet<Integer[]> treeSet = new TreeSet<>((a, b) -> a[0]-b[0]);

    public boolean book(int start, int end) {

        Integer[] entry = new Integer[]{start, end};
        boolean couldAdd = treeSet.add(entry);

        if(!couldAdd) return false;

        if(treeSet.size() == 0){
            treeSet.add(entry);
            return true;
        }

        // getLower and check
        Integer[] lower = treeSet.lower(entry);
        if(lower != null){
            // do Check
            if(entry[0] < lower[1] && lower[0] < entry[1]){
                treeSet.remove(entry);
                return false;
            }
        }

        Integer[] higher = treeSet.higher(entry);
        if(higher != null){
            // do check
            if(entry[0] < higher[1] && higher[0] < entry[1]){
                treeSet.remove(entry);
                return false;
            }
        }




        return true;

    }

    public static void main(String[] args) {
        MyCalenderI program = new MyCalenderI();

        System.out.println(program.book(10, 20 ));
        System.out.println(program.book(15,25));
        System.out.println(program.book(20, 30));

    }

}

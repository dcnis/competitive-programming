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
        boolean added = treeSet.add(entry);

        if(!added){
            return false;
        }

        if(treeSet.size() == 1) return true;

        Integer[] lowerThanStart = treeSet.lower(entry);

        if(lowerThanStart != null){
            if(entry[0] > lowerThanStart[0] && entry[0] < lowerThanStart[1]){
                treeSet.remove(entry);
                return false;
            }

            Integer[] higherThanEnd = treeSet.higher(entry);

            if(higherThanEnd != null){
                if(higherThanEnd[0] < entry[1]){
                    treeSet.remove(entry);
                    return false;
                }
            }

        } else {
            Integer[] higherThanEnd = treeSet.higher(entry);

            if(higherThanEnd != null){
                if(higherThanEnd[0] < entry[1]){
                    treeSet.remove(entry);
                    return false;
                }
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

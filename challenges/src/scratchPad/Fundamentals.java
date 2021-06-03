package scratchPad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fundamentals {

    private static void a(int a) {
        a++;
        b(a);
    }

    private static void b(int b) {
        b++;
    }

    public static void main(String[] args) {
        int x = 4;
        a(x);
        System.out.println(x);

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> megaList =  new ArrayList<>();

        megaList.add(List.of(5, 56));
        megaList.add(List.of(4, 51));
        megaList.add(List.of(2, 53));
        megaList.add(List.of(8, 52));
        megaList.add(List.of(5, 43));
        megaList.add(List.of(2, 80));
        megaList.add(List.of(5, 47));
        megaList.add(List.of(4, 79));
        megaList.add(List.of(3, 75));
        megaList.add(List.of(1, 67));
        megaList.add(List.of(7, 61));
        megaList.add(List.of(2, 57));
        megaList.add(List.of(5, 47));
        megaList.add(List.of(4, 63));
        megaList.add(List.of(10, 79));
        megaList.add(List.of(1, 57));
        megaList.add(List.of(4, 42));
        megaList.add(List.of(8, 79));
        megaList.add(List.of(6, 53));
        megaList.add(List.of(3, 74));
        megaList.add(List.of(7, 60));
        megaList.add(List.of(10, 79));
        megaList.add(List.of(5, 46));
        megaList.add(List.of(3, 50));
        megaList.add(List.of(6, 57));
        megaList.add(List.of(8, 71));
        megaList.add(List.of(6, 74));
        megaList.add(List.of(10, 44));
        megaList.add(List.of(9, 80));
        megaList.add(List.of(7, 59));
        megaList.add(List.of(7, 74));
        megaList.add(List.of(6, 55));
        megaList.add(List.of(3, 77));
        megaList.add(List.of(3, 53));
        megaList.add(List.of(5, 50));
        megaList.add(List.of(9, 70));
        megaList.add(List.of(4, 72));
        megaList.add(List.of(5, 73));
        megaList.add(List.of(6, 70));
        megaList.add(List.of(7, 46));

        for(List<Integer> list : megaList){
            if(!map.containsKey(list.get(0))){
                map.put(list.get(0), new ArrayList<>());
                map.get(list.get(0)).add(list.get(1));
            } else {
                map.get(list.get(0)).add(list.get(1));
            }


            if(!map.containsKey(list.get(1))){
                map.put(list.get(1), new ArrayList<>());
                map.get(list.get(1)).add(list.get(0));
            } else {
                map.get(list.get(1)).add(list.get(0));
            }
        }

        map.entrySet().forEach(key -> {
            System.out.println(key);
        });
    }

}

package leetcode.array;

import leetcode.utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeTheHalf {

    public int minSetSize(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        map.keySet().forEach(x -> pq.offer(x));

        int amount = 0;
        int size = 0;

        while(size < arr.length/2){
            size += map.get(pq.remove());
            amount++;
        }
        return amount;
    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        ReduceArraySizeTheHalf program = new ReduceArraySizeTheHalf();
        // should output 2
        System.out.println(program.minSetSize(utils.readArray("[3,3,3,3,5,5,5,2,2,7]")));
    }
}

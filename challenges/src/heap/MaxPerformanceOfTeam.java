package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxPerformanceOfTeam {

    private static int[] SPEED;
    private static int[] EFF;

    public int maxPerformance(int n, int[] speed, int[] eff, int k) {

        SPEED = speed;
        EFF = eff;

        Map<String, Long> cache = new HashMap<>();

        long result = recursion(n-1, k, 0l, Integer.MAX_VALUE, cache);

        return (int)(result % 1000000007);
    }

    private long recursion(int i, int k, long sum, int minEff, Map<String, Long> cache){

        if(i < 0){
            return sum*minEff;
        }

        if(k == 0) {
            return sum*minEff;
        }

        long maxTaken;
        long maxNotTaken;

        StringBuilder sb1 = new StringBuilder();
        sb1.append(i-1).append("-").append(k-1).append("-").append(sum+SPEED[i]).append("-").append(Math.min(minEff, EFF[i]));
        if(cache.containsKey(sb1.toString())){
            maxTaken = cache.get(sb1.toString());
        } else {
            maxTaken = recursion(i-1, k-1, sum + SPEED[i], Math.min(minEff, EFF[i]), cache);
            cache.put(sb1.toString(), maxTaken);
        }

        StringBuilder sb2 = new StringBuilder();
        sb2.append(i-1).append(k).append(sum).append(minEff);
        if(cache.containsKey(sb2.toString())){
            maxNotTaken = cache.get(sb2.toString());
        } else {
            maxNotTaken = recursion(i-1, k, sum, minEff, cache);
            cache.put(sb2.toString(), maxNotTaken);
        }

        return Math.max(maxTaken, maxNotTaken);

    }
    public static void main(String[] args) {
        MaxPerformanceOfTeam program = new MaxPerformanceOfTeam();
        // should return 60
        System.out.println(program.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2));


        // should return 68
        System.out.println(program.maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 3));

        // should return 72
        System.out.println(program.maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 4));
    }
}

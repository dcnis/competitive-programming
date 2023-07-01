package de.schmidtdennis.challenges.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxPerformanceOfTeam {

    public int maxPerformance(int n, int[] speed, int[] eff, int k) {

        // de.schmidtdennis.challenges.leetcode.sort the arrays according to eff
        int[][] effSpeed = new int[n][2];

        for (int i = 0; i < n; i++) {
            effSpeed[i][0] = eff[i];
            effSpeed[i][1] = speed[i];
        }

        Arrays.sort(effSpeed, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        long maxResult = Long.MIN_VALUE;
        long maxSum = 0;

        for (int i = 0; i < effSpeed.length; i++) {

            minHeap.add(effSpeed[i][1]);
            maxSum += effSpeed[i][1];

            if(minHeap.size() > k) {
                maxSum -= minHeap.poll();
            }

            long currResult = (long) effSpeed[i][0] * maxSum;

            maxResult = Math.max(maxResult, currResult);
        }

        return (int) (maxResult % (1e9+7));

    }

    public static void main(String[] args) {
        MaxPerformanceOfTeam program = new MaxPerformanceOfTeam();
        // should return 60
        System.out.println(program.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2));


        // should return 68
        System.out.println(program.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 3));

        // should return 72
        System.out.println(program.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 4));
    }


}

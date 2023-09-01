package de.schmidtdennis.challenges.leetcode.intervals;

import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if(a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
        });


        for(int i = 0; i < intervals.length; i++){
            pq.offer(new int[]{intervals[i][0], 1});
            pq.offer(new int[]{intervals[i][1], -1});
        }

        int max = 0;
        int cur = 0;

        while(!pq.isEmpty()){
            int[] time = pq.poll();
            cur += time[1];
            if(cur > max){
                max = cur;
            }
        }

        return max;
    }

}

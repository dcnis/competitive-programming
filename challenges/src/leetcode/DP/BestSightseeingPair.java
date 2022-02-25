package leetcode.DP;

import leetcode.utils.Utils;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/*
* 1014. Best Sightseeing Pair
* https://leetcode.com/problems/best-sightseeing-pair/
* */



public class BestSightseeingPair {

    static class Pair{
        int key;
        int index;

        public Pair(int key, int index){
            this.key = key;
            this.index = index;
        }


    }

    static class MyKey {
        int index;
        boolean buy;

        public MyKey(int index, boolean buy){
            this.index = index;
            this.buy = buy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyKey myKey = (MyKey) o;
            return index == myKey.index && buy == myKey.buy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, buy);
        }
    }

    public static int maxScoreSightseeingPair(int[] values) {

        Comparator<Pair> cp = (o1, o2) -> {

            int firstSum = o1.key - o1.index;
            int secondSum = o2.key - o2.index;

            return secondSum-firstSum;
        };

        PriorityQueue<Pair> pq = new PriorityQueue<>(cp);

        for(int i = 0; i < values.length; i++){
            pq.offer(new Pair(values[i], i));
        }

        Pair one = pq.poll();
        Pair two = pq.poll();



        return one.key - one.index + two.key - two.index;
    }


    public static void main(String[] args) {
        boolean b = true;

        System.out.println(0 + "-" + b);
        System.out.println(maxScoreSightseeingPair(Utils.readArray("[8,1,5,2,6]")));
    }
}

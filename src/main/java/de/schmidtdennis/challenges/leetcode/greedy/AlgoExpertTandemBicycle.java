package de.schmidtdennis.challenges.leetcode.greedy;

import de.schmidtdennis.challenges.leetcode.utils.Tag;
import de.schmidtdennis.challenges.leetcode.utils.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AlgoExpertTandemBicycle {

    public static int tandemBicycleSolution1(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

        PriorityQueue<Integer> maxHeapRed = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxHeapBlue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < redShirtSpeeds.length; i++){
            maxHeapRed.add(redShirtSpeeds[i]);
            maxHeapBlue.add(blueShirtSpeeds[i]);
        }

        Integer total = 0;
        for(int i  = 0; i < redShirtSpeeds.length; i++){

            if(fastest){
                if(maxHeapRed.peek() > maxHeapBlue.peek()){
                    total += maxHeapRed.poll();
                } else {
                    total += maxHeapBlue.poll();
                }
            } else {
                if(maxHeapRed.peek() > maxHeapBlue.peek()){
                    total += maxHeapRed.poll();
                    maxHeapBlue.poll(); // take the second largest
                } else {
                    total += maxHeapBlue.poll();
                    maxHeapRed.poll();
                }
            }

        }

        return total;
    }

    public static int tandemBicycleSolution2(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if(!fastest){
            reverseArrayInPlace(redShirtSpeeds);
        }

        int total = 0;
        for(int i = 0; i < redShirtSpeeds.length; i++){
            int speed1 = redShirtSpeeds[i];
            int speed2 = blueShirtSpeeds[blueShirtSpeeds.length-i-1];
            total += Math.max(speed1, speed2);
        }

        return total;
    }

    private static void reverseArrayInPlace(int[] blueShirtSpeeds) {

        int start = 0, end = blueShirtSpeeds.length-1;

        while(start < end){
            int temp = blueShirtSpeeds[start];
            blueShirtSpeeds[start] = blueShirtSpeeds[end];
            blueShirtSpeeds[end] = temp;
            start++;
            end--;
        }

    }

    public static void main(String[] args) {
        System.out.println(Tag.GREEDY);
        System.out.println(tandemBicycleSolution1(Utils.readIntArray("5, 5, 3, 9, 2"), Utils.readIntArray("3, 6, 7, 2, 1"), true)); // 32
    }

}

package de.schmidtdennis.challenges.leetcode.matrix;

import java.util.Arrays;

public class AreaAfterCuts {

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        // find maximum gap of vertical lines
        long maxGapVertical = findMaximumGap(verticalCuts, w);
        long maxGapHorizontal = findMaximumGap(horizontalCuts, h);

        // find maximum gap of horizontal lines
        long maxGap = (maxGapHorizontal*maxGapVertical) % 1000000007;

        return (int)maxGap;
    }

    private static long findMaximumGap(int[] cuts, int maxLength) {
        long maxGap = cuts[0];

        for(int i = cuts.length-1; i > 0; i--){
            long gap = cuts[i] - cuts[i-1];
            if(gap > maxGap){
                maxGap = gap;
            }
        }

        return Math.max(maxGap, maxLength - cuts[cuts.length-1]);
    }

    public static void main(String[] args) {
        // should return 4
        System.out.println(maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));

        // should return 6
        System.out.println(maxArea(5, 4, new int[]{3, 1}, new int[]{1}));

        // should return 51
        System.out.println(maxArea(50, 15, new int[]{37,40,41,30,27,10,31}, new int[]{2,1,9,5,4,12,6,13,11}));

        // should return 9
        System.out.println(maxArea(5, 4, new int[]{3}, new int[]{3}));




    }
}

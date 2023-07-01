package de.schmidtdennis.challenges.leetcode.DP;

import de.schmidtdennis.challenges.leetcode.utils.Utils;

/*
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * */
public class TrappingRainWater {

    public static int trapBruteForce(int[] height) {
        if (height.length < 3) return 0;

        int trap = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int leftMaxHeight = -1;

            for (int left = i - 1; left >= 0; left--) {
                // find left max Height
                leftMaxHeight = Math.max(height[left], leftMaxHeight);
            }

            int rightMaxHeight = -1;
            for (int right = i + 1; right < height.length; right++) {
                // find right Max Height
                rightMaxHeight = Math.max(height[right], rightMaxHeight);
            }

            int minWall = Math.min(leftMaxHeight, rightMaxHeight);

            if (minWall > height[i]) {
                trap += minWall - height[i];
            }

        }

        return trap;
    }


    public static int trapDP(int[] height) {
        if (height.length < 3) return 0;

        int trap = 0;
        int[] dpLeft = new int[height.length];
        int[] dpRight = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            int lastIndex = height.length - 1 - i;
            dpLeft[i] = Math.max(dpLeft[i - 1], height[i - 1]);
            dpRight[lastIndex] = Math.max(dpRight[lastIndex + 1], height[lastIndex + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {

            int minWall = Math.min(dpLeft[i], dpRight[i]);

            if (minWall > height[i]) {
                trap += minWall - height[i];
            }

        }

        return trap;
    }

    public static void main(String[] args) {
        System.out.println(trapBruteForce(Utils.readIntArray("[0,1,0,2,1,0,1,3,2,1,2,1]"))); // 6
        System.out.println(trapBruteForce(Utils.readIntArray("[4,2,0,3,2,5]"))); // 9
        System.out.println();
        System.out.println(trapDP(Utils.readIntArray("[0,1,0,2,1,0,1,3,2,1,2,1]"))); // 6
        System.out.println(trapDP(Utils.readIntArray("[4,2,0,3,2,5]"))); // 9


    }
}

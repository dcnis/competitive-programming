package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if(nums.length == 0 ) return 0;

        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int num : nums){
            // find the min
            if(!set.contains(num-1)){
                int value = num;
                int count = 0;
                while(set.contains(value)){
                    count++;
                    value++;
                }
                max = Math.max(max, count);
            }
        }


        return max;

    }


    public static void main(String[] args) {

        LongestConsecutiveSequence program = new LongestConsecutiveSequence();
        // should output 2
        System.out.println(program.longestConsecutive(new int[]{0, -1}));

        // should output 4
        System.out.println(program.longestConsecutive(new int[]{100,4,200,1,3,2}));

        // should output 5
        System.out.println(program.longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));
    }
}

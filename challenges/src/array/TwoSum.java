package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* TwoSum HashMap Solution
* */
class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3, 2, 4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {


        Map<Integer, Integer> map = new HashMap<>();

        int[] solution = new int[2];

        for(int j = 0; j < nums.length; j++) {
            map.put(nums[j], j);
        }

        for(int j = 0; j < nums.length; j++) {
            int rest = target - nums[j];

            if(map.containsKey(rest) && (map.get(rest) != j)){
                // we found a solution
                solution[0] = j;
                solution[1] = map.get(rest);
                break;
            }
        }

        return solution;

    }

}

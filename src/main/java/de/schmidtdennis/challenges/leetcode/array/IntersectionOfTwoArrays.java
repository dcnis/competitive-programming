package de.schmidtdennis.challenges.leetcode.array;


import de.schmidtdennis.challenges.leetcode.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
* 350. Intersection of Two Arrays II
* https://leetcode.com/problems/intersection-of-two-arrays-ii/
* */
public class IntersectionOfTwoArrays {

    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;

        List<Integer> list = new ArrayList<>();

        while(i < nums1.length && j<nums2.length){

            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else {
                i++;
            }
        }


        return list.stream()
                .mapToInt(x -> x)
                .toArray();
    }

    public static int[] intersectWithHashMap(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && (map.get(nums2[i]) > 0)){
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        return list.stream().mapToInt(x->x).toArray();

    }

    public static void main(String[] args) {
        // [2, 2]
        System.out.println(Arrays.toString(intersect(Utils.readIntArray("[1,2,2,1]"), Utils.readIntArray("[2,2]"))));

        // [9, 4]
        System.out.println(Arrays.toString(intersectWithHashMap(Utils.readIntArray("[4,9,5]"), Utils.readIntArray("[9,4,9,8,4]"))));
    }
}

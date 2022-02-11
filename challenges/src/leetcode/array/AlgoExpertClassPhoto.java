package leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* AlgoExpert: Class Photo
* Link: https://www.algoexpert.io/questions/Class%20Photos
* */
public class AlgoExpertClassPhoto {

    public static boolean classPhotos(
            List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {

        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        boolean blueInBack = blueShirtHeights.get(0) > redShirtHeights.get(0);
        for(int i = 0; i < redShirtHeights.size(); i++){
            if(blueInBack && blueShirtHeights.get(i) <= redShirtHeights.get(i)){
                return false;
            }

            if(!blueInBack && redShirtHeights.get(i) <= blueShirtHeights.get(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(classPhotos(Arrays.asList(5, 8, 1, 3, 4), Arrays.asList(6, 9, 2, 4, 5))); // expected: true
    }
}

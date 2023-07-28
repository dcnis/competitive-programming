package de.schmidtdennis.challenges.leetcode.DP;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@MockitoSettings
class CoinChangeIITest {

    @InjectMocks
    private CoinChangeII testee;

    @Test
    public void test(){
        System.out.println(testee.change(3, new int[]{1, 2, 5}));
    }

    @Test
    public void test2(){
        int[][] memo = new int[10][1001];
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }

        List<Integer> usageLimits = Arrays.asList(1, 2,3);
        int[] arr = usageLimits.stream().mapToInt(x -> x).toArray();
        Arrays.sort(arr);

        List<String> words = Arrays.asList("$easy$","$problem$");
        char sep = '$';

        List<String> ans = new ArrayList<>();
        for(String str : words){
            String[] split = str.split("\\" + sep);
            for(String w : split){
                if(w != null && w.length() > 0){
                    ans.add(w);
                }
            }
        }
        System.out.println(ans);
    }
}

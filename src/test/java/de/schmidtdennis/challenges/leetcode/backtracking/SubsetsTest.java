package de.schmidtdennis.challenges.leetcode.backtracking;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;


@MockitoSettings
class SubsetsTest {

    @InjectMocks
    private Subsets testee;

    @Test
    public void test(){
        List<List<Integer>> subsets = testee.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}

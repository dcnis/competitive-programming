package de.schmidtdennis.challenges.leetcode.DP.freeCodeCampDPCourse;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class HowSumTest {

    @InjectMocks
    private HowSum testee;

    @Test
    public void test(){
        // GIVEN

        // WHEN
        List<List<Integer>> integers = testee.howSum(new int[]{2, 3}, 8);

        // THEN
        System.out.println(integers);
    }

}

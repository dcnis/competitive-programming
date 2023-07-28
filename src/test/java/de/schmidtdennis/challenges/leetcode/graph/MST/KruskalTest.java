package de.schmidtdennis.challenges.leetcode.graph.MST;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;


@MockitoSettings
class KruskalTest {

    @InjectMocks
    private Kruskal testee;

    @Test
    public void test(){
        testee.minCostConnectPoints(new int[][]{{0,0}, {1,1}, {1,0}, {-1, 1}});
    }
}

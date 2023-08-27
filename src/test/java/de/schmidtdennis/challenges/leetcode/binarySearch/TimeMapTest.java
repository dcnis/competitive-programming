package de.schmidtdennis.challenges.leetcode.binarySearch;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;


@MockitoSettings
class TimeMapTest {

    @InjectMocks
    private TimeMap testee;

    @Test
    public void test(){
        testee.set("foo", "bar", 1);
        System.out.println(testee.get("foo", 1));
        System.out.println(testee.get("foo", 3));
        testee.set("foo", "bar2", 4);
        System.out.println(testee.get("foo", 4));
        System.out.println(testee.get("foo", 5));
    }
}

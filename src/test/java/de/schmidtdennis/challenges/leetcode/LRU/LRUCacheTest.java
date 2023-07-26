package de.schmidtdennis.challenges.leetcode.LRU;

import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;


@MockitoSettings
class LRUCacheTest {

    @Test
    public void test(){
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println(lru.get(3));
        System.out.println(lru.get(2));
        System.out.println(lru.get(1));
    }

}
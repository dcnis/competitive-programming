package de.schmidtdennis.challenges.leetcode.tries;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;


@MockitoSettings
class TrieTest {

    @InjectMocks
    private Trie testee;

    @Test
    public void testTrie(){
        testee.insert("apple");
        Assertions.assertThat(testee.search("apple")).isTrue();
        Assertions.assertThat(testee.search("app")).isFalse();
        Assertions.assertThat(testee.startsWith("app")).isTrue();
        testee.insert("app");
        Assertions.assertThat(testee.search("app")).isTrue();
    }

}

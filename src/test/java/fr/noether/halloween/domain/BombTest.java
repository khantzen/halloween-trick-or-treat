package fr.noether.halloween.domain;

import org.junit.Test;

import static fr.noether.halloween.domain.TestConstant.*;

public class BombTest {
    @Test
    public void someone_got_the_bomb() {
        assertTrickOrTreat(2, bagOfTwoCandies(), bagOfTwoCandiesWithABomb());
    }

    @Test
    public void no_one_got_the_bomb() {
        assertThankYouStrangeUncle(
                2,
                bagOfTwoCandies(),
                bagOfTwoCandies(),
                bagOfTwoCandiesWithABomb()
        );
    }
}

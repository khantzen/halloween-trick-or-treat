package fr.noether.halloween.domain;

import org.junit.Test;

import static fr.noether.halloween.domain.TestConstant.*;

public class NotEnoughCandyTest {
    @Test
    public void not_enough_bags() {
        assertTrickOrTreat(2, bagOfTwoCandies());
    }

    @Test
    public void not_enough_candy_for_everyone() {
        assertTrickOrTreat(2, bagOfTwoCandies(), bagOfOneCandy());
        assertTrickOrTreat(3, bagOfTwoCandies(), bagOfTwoCandies(), bagOfTwoApple());
    }

}

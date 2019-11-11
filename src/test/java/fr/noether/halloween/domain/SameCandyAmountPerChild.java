package fr.noether.halloween.domain;

import org.junit.Test;

import static fr.noether.halloween.domain.TestConstant.*;

public class SameCandyAmountPerChild {
    @Test
    public void children_should_have_the_same_candy_amount() {
        assertTrickOrTreat(2, bagOfTwoCandies(), bagOfThreeCandies());
        assertThankYouStrangeUncle(3, bagOfThreeCandies(), bagOfThreeCandies(), bagOfThreeCandies());
        assertThankYouStrangeUncle(3,
                bagOfThreeCandies(),
                bagOfThreeCandies(),
                bagOfThreeCandies(),
                bagOfTwoCandies(),
                bagOfTwoCandies(),
                bagOfTwoCandies()
                );

    }
}

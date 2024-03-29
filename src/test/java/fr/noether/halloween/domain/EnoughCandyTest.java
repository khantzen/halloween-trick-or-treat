package fr.noether.halloween.domain;

import org.junit.Test;

import static fr.noether.halloween.domain.TestConstant.assertThankYouStrangeUncle;
import static fr.noether.halloween.domain.TestConstant.bagOfTwoCandies;

public class EnoughCandyTest {
    @Test
    public void everyone_got_what_he_wants() {
        assertThankYouStrangeUncle(2, bagOfTwoCandies(), bagOfTwoCandies());
        assertThankYouStrangeUncle(3, bagOfTwoCandies(), bagOfTwoCandies(), bagOfTwoCandies());
        assertThankYouStrangeUncle(2, bagOfTwoCandies(), bagOfTwoCandies(), bagOfTwoCandies());
    }

}

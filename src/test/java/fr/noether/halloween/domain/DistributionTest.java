package fr.noether.halloween.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DistributionTest {
    private static final String TRICK_OR_TREAT = "Trick or treat!";
    private static final String THANK_YOU_STRANGE_UNCLE = "Thank you strange uncle!";
    private static final String CANDY = "candy";
    private static final String APPLE = "apple";
    private static final String BOMB = "bomb";

    private static Bag bagOfOneCandy() {
        return Bag.of(CANDY);
    }

    private static Bag bagOfTwoCandies() {
        return Bag.of(CANDY, CANDY);
    }

    private static Bag bagOfTwoApple() {
        return Bag.of(APPLE, APPLE);
    }

    private Bag bagOfTwoCandiesWithABomb() {
        return Bag.of(CANDY, CANDY, BOMB);
    }

    @Test
    public void not_enough_bags() {
        assertTrickOrTreat(2, bagOfTwoCandies());
    }

    @Test
    public void not_enough_candy_for_everyone() {
        assertTrickOrTreat(2, bagOfTwoCandies(), bagOfOneCandy());
        assertTrickOrTreat(3, bagOfTwoCandies(), bagOfTwoCandies(), bagOfTwoApple());
    }

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

    @Test
    public void everyone_got_what_he_wants() {
        assertThankYouStrangeUncle(2, bagOfTwoCandies(), bagOfTwoCandies());
        assertThankYouStrangeUncle(3, bagOfTwoCandies(), bagOfTwoCandies(), bagOfTwoCandies());
        assertThankYouStrangeUncle(2, bagOfTwoCandies(), bagOfTwoCandies(), bagOfTwoCandies());
    }

    private void assertTrickOrTreat(int childrenCount, Bag... bags) {
        Children children = new Children(childrenCount);
        UncleJack jack = UncleJack.with(bags);
        String answer = children.ask(jack);
        Assertions.assertThat(answer).isEqualTo(TRICK_OR_TREAT);
    }

    private void assertThankYouStrangeUncle(int childrenCount, Bag... bags) {
        Children children = new Children(childrenCount);
        UncleJack jack = UncleJack.with(bags);
        String answer = children.ask(jack);
        Assertions.assertThat(answer).isEqualTo(THANK_YOU_STRANGE_UNCLE);
    }
}

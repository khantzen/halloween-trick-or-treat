package fr.noether.halloween.domain;

import org.assertj.core.api.Assertions;

class TestConstant {
    static final String TRICK_OR_TREAT = "Trick or treat!";
    static final String THANK_YOU_STRANGE_UNCLE = "Thank you strange uncle!";
    static final String CANDY = "candy";
    private static final String APPLE = "apple";
    static final String BOMB = "bomb";

    static Bag bagOfOneCandy() {
        return Bag.of(CANDY);
    }

    static Bag bagOfTwoCandies() {
        return Bag.of(CANDY, CANDY);
    }

    static Bag bagOfTwoApple() {
        return Bag.of(APPLE, APPLE);
    }

    static Bag bagOfTwoCandiesWithABomb() {
        return Bag.of(CANDY, CANDY, BOMB);
    }

    static void assertTrickOrTreat(int childrenCount, Bag... bags) {
        Children children = new Children(childrenCount);
        UncleJack jack = UncleJack.with(bags);
        String answer = children.ask(jack);
        Assertions.assertThat(answer).isEqualTo(TRICK_OR_TREAT);
    }

    static void assertThankYouStrangeUncle(int childrenCount, Bag... bags) {
        Children children = new Children(childrenCount);
        UncleJack jack = UncleJack.with(bags);
        String answer = children.ask(jack);
        Assertions.assertThat(answer).isEqualTo(THANK_YOU_STRANGE_UNCLE);
    }
}

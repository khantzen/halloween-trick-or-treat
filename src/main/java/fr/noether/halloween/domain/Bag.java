package fr.noether.halloween.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Bag {
    private final String[] content;

    private Bag(String[] candy) {
        this.content = candy;
    }

    public static Bag of(String... candy) {
        return new Bag(candy);
    }

    boolean doesContainEnoughCandy() {
        var candiesInBag = Arrays.stream(content)
                .filter("candy"::equals)
                .count();
        return candiesInBag >= 2;
    }

    boolean doesNotContainTheBomb() {
        long count = Arrays.stream(content)
                .filter("bomb"::equals)
                .count();
        return count == 0;
    }

    CandyPerBagGrouping candyCount() {
        var candyInBag = Arrays.stream(content)
                .filter("candy"::equals)
                .count();

        return CandyPerBagGrouping.singleBagWith(candyInBag);
    }
}

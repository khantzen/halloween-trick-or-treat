package fr.noether.halloween.domain;

import java.util.Arrays;

public class Bag {
    private final String[] content;

    public Bag(String[] candy) {
        this.content = candy;
    }

    public static Bag of(String... candy) {
        return new Bag(candy);
    }

    public boolean doesContainEnoughCandy() {
        var candiesInBag = Arrays.stream(content)
                .filter("candy"::equals)
                .count();
        return candiesInBag >= 2;
    }

    public boolean doesNotContainTheBomb() {
        long count = Arrays.stream(content)
                .filter("bomb"::equals)
                .count();
        return count == 0;
    }
}

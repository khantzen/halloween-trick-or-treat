package fr.noether.halloween.domain;

import java.util.Arrays;

public class UncleJack {
    public final Bag[] bags;

    public UncleJack(Bag[] bags) {
        this.bags = bags;
    }

    public static UncleJack with(Bag... bags) {
        return new UncleJack(bags);
    }

    public long suitableBagsCount() {
        return Arrays.stream(bags)
                .filter(Bag::doesNotContainTheBomb)
                .filter(Bag::doesContainEnoughCandy)
                .map(Bag::candyCount)
                .reduce(CandyPerBagGrouping.empty(), CandyPerBagGrouping::merge)
                .maximumAvailableBags();
    }
}

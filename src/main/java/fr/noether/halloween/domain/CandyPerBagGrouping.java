package fr.noether.halloween.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class CandyPerBagGrouping {
    private final Map<Long, Long> group;

    private CandyPerBagGrouping(Long candyCount, Long bagCount) {
        this.group = new HashMap<>();
        this.group.put(candyCount, bagCount);
    }

    private CandyPerBagGrouping(Map<Long, Long> group) {
        this.group = group;
    }

    static CandyPerBagGrouping singleBagWith(long candyInBag) {
        return new CandyPerBagGrouping(candyInBag, 1L);
    }

    static CandyPerBagGrouping empty() {
        return new CandyPerBagGrouping(new HashMap<>());
    }

    static CandyPerBagGrouping merge(CandyPerBagGrouping accumulator, CandyPerBagGrouping newOne) {
        Map<Long, Long> result = new HashMap<>(accumulator.group);
        BiFunction<Long, Long, Long> sumBag =
                (accBag, bagToAdd) -> Long.sum(bagToAdd, accBag);

        newOne.group.forEach((candies, bags) ->
                result.merge(candies, bags, sumBag)
        );

        return new CandyPerBagGrouping(result);
    }

    long maximumAvailableBags() {
        return group.values().stream()
                .max(Long::compareTo)
                .orElse(0L);
    }
}

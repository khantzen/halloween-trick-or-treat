package fr.noether.halloween.domain;

public class Children {
    private final int count;

    public Children(int count) {
        this.count = count;
    }

    public String ask(UncleJack jack) {
        if (jack.suitableBagsCount() >= count) {
            return "Thank you strange uncle!";
        }
        return "Trick or treat!";
    }
}

package nl.mwensveen.adventofcode.year_2023.day_16;

public enum Item {
    EMPTY_SPACE("."),
    MIRROR_SLASH("/"),
    MIRROR_BACKSLASH("\\"),
    SPLITTER_HORIZONTAL("-"),
    SPLITTER_VERTICAL("|");

    private final String symbol;

    Item(String symbol) {
        this.symbol = symbol;
    }

    public static Item find(String symbol) {
        for (Item elem : Item.values()) {
            if (elem.symbol.equals(symbol)) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid Item requested " + symbol);
    }

}

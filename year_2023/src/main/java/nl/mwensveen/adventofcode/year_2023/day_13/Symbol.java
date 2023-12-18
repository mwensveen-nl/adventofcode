package nl.mwensveen.adventofcode.year_2023.day_13;

import javax.annotation.Nonnull;

public enum Symbol {

    ASH("."),
    ROCK("#");

    private String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    @Nonnull
    public static Symbol find(String symbol) {
        for (Symbol elem : Symbol.values()) {
            if (elem.symbol.equals(symbol)) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid Symbol requested " + symbol);
    }

}

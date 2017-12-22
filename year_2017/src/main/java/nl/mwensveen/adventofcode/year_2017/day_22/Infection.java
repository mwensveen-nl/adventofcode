package nl.mwensveen.adventofcode.year_2017.day_22;

public enum Infection {
    INFECTED("#"),
    CLEAN("."),
    WEAKENED("W"),
    FLAGGED("F");
    private String symbol;

    private Infection(String symbol) {
        this.symbol = symbol;
    }

    public static Infection get(String getForSymbol) {
        if (getForSymbol.equals(INFECTED.symbol)) {
            return INFECTED;
        }
        if (getForSymbol.equals(CLEAN.symbol)) {
            return CLEAN;
        }
        throw new RuntimeException("Invalid symbol " + getForSymbol);
    }
}

package nl.mwensveen.adventofcode.year_2020.day_11;

public enum PositionState {
    OCCUPIED("#"),
    EMPTY("L"),
    FLOOR(".");

    private String symbol;

    PositionState(String symbol) {
        this.symbol = symbol;
    }

    public static PositionState find(String symbol) {
        for (PositionState elem : PositionState.values()) {
            if (elem.symbol.equals(symbol)) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid PositionState requested " + symbol);
    }

}

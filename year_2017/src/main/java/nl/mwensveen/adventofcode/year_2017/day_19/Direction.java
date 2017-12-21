package nl.mwensveen.adventofcode.year_2017.day_19;

public enum Direction {
    Down("|"),
    Up("|"),
    Right("-"),
    Left("-"),
    Switch("+"),
    End("");

    private final String symbol;

    private Direction(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

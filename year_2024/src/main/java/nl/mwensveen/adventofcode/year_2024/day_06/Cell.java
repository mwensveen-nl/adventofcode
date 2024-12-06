package nl.mwensveen.adventofcode.year_2024.day_06;

public enum Cell {
    OBSTRUCTION("#"),
    EMPTY("."),
    VISITED("*"),
    GUARD("^");

    private String symbol;

    Cell(String symbol) {
        this.symbol = symbol;
    }

    public static Cell find(String symbol) {
        for (Cell elem : Cell.values()) {
            if (elem.symbol.equals(symbol)) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid Cell requested " + symbol);
    }

}

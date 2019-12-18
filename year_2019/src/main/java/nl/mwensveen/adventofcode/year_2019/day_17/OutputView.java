package nl.mwensveen.adventofcode.year_2019.day_17;

public enum OutputView {
    SCAFFOLD(35, "#"),
    OPEN_SPACE(46, "."),
    NEW_LINE(10, ""),
    ROBOT(94, "^");

    private final int number;
    private final String symbol;

    private OutputView(int number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static OutputView valueOf(int number) {
        for (OutputView elem : OutputView.values()) {
            if (elem.number == number) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid OutputView requested " + number);
    }

}

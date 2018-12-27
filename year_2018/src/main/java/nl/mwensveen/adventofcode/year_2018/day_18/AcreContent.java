package nl.mwensveen.adventofcode.year_2018.day_18;

public enum AcreContent {
    OPEN("."),
    TREES("|"),
    LUMBER("#");

    private final String symbol;

    private AcreContent(String symbol) {
        this.symbol = symbol;
    }

    public static AcreContent valueFromSymbol(String find) {
        for (AcreContent ac : AcreContent.values()) {
            if (ac.symbol.equals(find)) {
                return ac;
            }
        }
        throw new RuntimeException("Cannot find AcreContent for " + find);
    }

    public String getSymbol() {
        return symbol;
    }

}

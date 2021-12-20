package nl.mwensveen.adventofcode.year_2021.day_20;

public enum Pixel {
    LIGHT("#", "1"),
    DARK(".", "0");

    private final String symbol;
    private final String bit;

    Pixel(String symbol, String bit) {
        this.symbol = symbol;
        this.bit = bit;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getBit() {
        return bit;
    }

    public static Pixel find(String symbol) {
        for (Pixel elem : Pixel.values()) {
            if (elem.symbol.equals(symbol)) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid Pixel requested " + symbol);
    }

}

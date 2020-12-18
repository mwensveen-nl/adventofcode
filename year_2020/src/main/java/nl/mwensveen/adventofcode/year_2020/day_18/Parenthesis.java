package nl.mwensveen.adventofcode.year_2020.day_18;

enum Parenthesis {
    OPEN("("),
    CLOSE(")");

    private String c;

    Parenthesis(String c) {
        this.c = c;
    }

    public static Parenthesis find(String symbol) {
        for (Parenthesis p : Parenthesis.values()) {
            if (p.c.equals(symbol)) {
                return p;
            }
        }
        throw new RuntimeException("Invalid symbol " + symbol);
    }

    public static boolean isParenthesis(String symbol) {
        for (Parenthesis p : Parenthesis.values()) {
            if (p.c.equals(symbol)) {
                return true;
            }
        }
        return false;
    }
}
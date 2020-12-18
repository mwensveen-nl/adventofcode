package nl.mwensveen.adventofcode.year_2020.day_18;

enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String c;

    Operator(String c) {
        this.c = c;
    }

    public static Operator find(String symbol) {
        for (Operator o : Operator.values()) {
            if (o.c.equals(symbol)) {
                return o;
            }
        }
        throw new RuntimeException("Symbol " + symbol + " not found");
    }

    public static boolean isOperator(String string) {
        for (Operator o : Operator.values()) {
            if (o.c.equals(string)) {
                return true;
            }
        }
        return false;
    }
}
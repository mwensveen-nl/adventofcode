package nl.mwensveen.adventofcode.year_2023.day_10;

public enum Pipes {
    NS("|", Direction.NORD, Direction.SOUTH),
    EW("-", Direction.EAST, Direction.WEST),
    NE("L", Direction.NORD, Direction.EAST),
    NW("J", Direction.NORD, Direction.WEST),
    SW("7", Direction.SOUTH, Direction.WEST),
    SE("F", Direction.SOUTH, Direction.EAST),
    START("S", null, null);

    private final String symbol;
    private final Direction one;
    private final Direction two;

    public static Pipes find(String symbol) {
        for (Pipes elem : Pipes.values()) {
            if (elem.symbol.equals(symbol)) {
                return elem;
            }
        }
        return null;
    }

    Pipes(String symbol, Direction one, Direction two) {
        this.symbol = symbol;
        this.one = one;
        this.two = two;

    }

    public String getSymbol() {
        return symbol;
    }

    public Direction getOne() {
        return one;
    }

    public Direction getTwo() {
        return two;
    }

    public boolean canStepToThis(Pipes currentPipe, Direction stepTo) {
        if (currentPipe.one == stepTo || currentPipe.two == stepTo || currentPipe == START) {
            Direction reverse = stepTo.reverse();
            return one == reverse || two == reverse;
        }
        return false;
    }

    public Direction step(Direction stepTo) {
        if (one.getX() == stepTo.getX() * -1 && one.getY() == stepTo.getY() * -1) {
            return two;
        }
        return one;
    }
}

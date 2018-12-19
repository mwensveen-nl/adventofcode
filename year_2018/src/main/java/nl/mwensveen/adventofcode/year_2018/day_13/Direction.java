package nl.mwensveen.adventofcode.year_2018.day_13;

import java.util.Optional;

public enum Direction {
    // Order of directions = make left turn
    UP(0, -1, "^"),
    LEFT(-1, 0, "<"),
    DOWN(0, 1, "v"),
    RIGHT(1, 0, ">");

    private int x;
    private int y;
    private String symbol;

    private Direction(int x, int y, String symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public Position move(Position curPosition) {
        return new Position(curPosition.getX() + x, curPosition.getY() + y);
    }

    public static Optional<Direction> valueFrom(String symbol) {
        for (Direction d : Direction.values()) {
            if (d.symbol.equals(symbol)) {
                return Optional.of(d);
            }
        }
        return Optional.empty();
    }

}

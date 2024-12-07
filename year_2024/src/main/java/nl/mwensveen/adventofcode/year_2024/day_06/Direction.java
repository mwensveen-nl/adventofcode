package nl.mwensveen.adventofcode.year_2024.day_06;

public enum Direction {
    UP(-1, 0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1);

    private final int rowModifier;
    private final int colModifier;

    Direction(int rowModifier, int colModifier) {
        this.rowModifier = rowModifier;
        this.colModifier = colModifier;
    }

    public Direction turn() {
        return switch (this) {
            case UP -> RIGHT;
            case RIGHT -> DOWN;
            case DOWN -> LEFT;
            case LEFT -> UP;
        };
    }

    public int getRowModifier() {
        return rowModifier;
    }

    public int getColModifier() {
        return colModifier;
    }

}

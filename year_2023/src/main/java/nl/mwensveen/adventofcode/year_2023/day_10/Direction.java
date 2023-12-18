package nl.mwensveen.adventofcode.year_2023.day_10;

public enum Direction {
    NORD(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    private final int y;
    private final int x;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
        // TODO Auto-generated constructor stub
    }

    Direction reverse() {
        return switch (this) {
            case NORD -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORD;
            case WEST -> EAST;
            default -> throw new IllegalArgumentException("Unexpected value: " + this);
        };
    }
}

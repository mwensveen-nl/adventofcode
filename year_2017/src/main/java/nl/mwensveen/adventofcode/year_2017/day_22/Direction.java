package nl.mwensveen.adventofcode.year_2017.day_22;

public enum Direction {
    UP(1),
    RIGHT(2),
    DOWN(3),
    LEFT(4);

    private final int number;

    private Direction(int number) {
        this.number = number;

    }

    public Direction turnLeft() {
        return findByNumber(number - 1);
    }

    public Direction turnRight() {
        return findByNumber(number + 1);
    }

    private Direction findByNumber(int i) {
        int n = i;
        if (i == 0) {
            n = 4;
        }
        if (i > 4) {
            n = n - 4;
        }

        for (Direction d : Direction.values()) {
            if (d.number == n) {
                return d;
            }
        }
        throw new RuntimeException();
    }

    public Direction reverse() {
        return findByNumber(number + 2);
    }
}

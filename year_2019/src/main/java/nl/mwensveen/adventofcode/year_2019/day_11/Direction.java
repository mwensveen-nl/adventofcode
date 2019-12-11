package nl.mwensveen.adventofcode.year_2019.day_11;

public enum Direction {
    UP(1, 4, 2, 1, 0),
    RIGHT(2, 1, 3, 0, 1),
    DOWN(3, 2, 4, -1, 0),
    LEFT(4, 3, 1, 0, -1);

    private final int number;
    private final int turnLeft;
    private final int turnRight;
    private final int stepX;
    private final int stepY;

    private Direction(int number, int turnLeft, int turnRight, int stepX, int stepY) {
        this.number = number;
        this.turnLeft = turnLeft;
        this.turnRight = turnRight;
        this.stepX = stepX;
        this.stepY = stepY;
    }

    public Direction turn(int turningDirection) {
        switch (turningDirection) {
            case 0:
                return find(turnLeft);
            case 1:
                return find(turnRight);
            default:
                throw new RuntimeException("invalid turn " + turningDirection);
        }

    }

    public Point step(Point p) {
        return new Point(stepX + p.getX(), stepY + p.getY());
    }

    private Direction find(int newNumber) {
        for (Direction element : Direction.values()) {
            if (element.number == newNumber) {
                return element;
            }
        }
        throw new RuntimeException("unkown direction " + number);
    }
}

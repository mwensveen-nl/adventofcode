package nl.mwensveen.adventofcode.year_2024.day_06;

public class Guard {

    private Position position;
    private Direction direction = Direction.UP;

    public Guard(int r, int c) {
        position = new Position(r, c);
    }

    public Position inspect() {
        return position.step(direction);
    }

    public Position step() {
        position = inspect();
        return position;
    }

    public void turnRight() {
        direction = direction.turn();

    }

}

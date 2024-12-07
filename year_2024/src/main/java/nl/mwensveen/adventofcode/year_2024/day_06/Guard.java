package nl.mwensveen.adventofcode.year_2024.day_06;

public class Guard {

    private Position position;
    private Direction direction = Direction.UP;

    public Guard(int r, int c) {
        position = new Position(r, c);
    }

    public Position inspect() {
        return getPosition().step(getDirection());
    }

    public Position step() {
        position = inspect();
        return getPosition();
    }

    public void turnRight() {
        direction = getDirection().turn();

    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

}

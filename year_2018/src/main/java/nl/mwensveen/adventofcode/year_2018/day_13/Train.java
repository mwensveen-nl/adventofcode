package nl.mwensveen.adventofcode.year_2018.day_13;

import com.google.common.base.MoreObjects;

public class Train {
    private Position position;
    private Direction direction;
    private Turn nextTurn = Turn.LEFT;
    private boolean deleted = false;

    public boolean isActive() {
        return !deleted;
    }

    public Train(int x, int y, Direction direction) {
        this.direction = direction;
        position = new Position(x, y);
    }

    public void delete() {
        deleted = true;
    }

    public Position move(TrackPart trackPart) {
        switch (trackPart) {
            case STRAIGHT_HORIZONTAL:
            case STRAIGHT_VERTICAL:
                position = moveStraight();
                break;
            case CURVE_LEFT:
                position = moveCurve(Turn.LEFT);
                break;
            case CURVE_RIGHT:
                position = moveCurve(Turn.RIGHT);
                break;
            case CROSSING:
                position = moveCrossing();
                break;
        }
        return position;
    }

    public Position getPosition() {
        return position;
    }

    public boolean collision(Train other) {
        if (this.isActive() && other.isActive()) {
            return this != other && position.equals(other.position);
        }
        return false;
    }

    private Position moveCrossing() {
        direction = nextTurn.makeTurnAtCrossing(direction);
        nextTurn = nextTurn.nextTurn();
        return direction.move(position);
    }

    private Position moveCurve(Turn turn) {
        direction = turn.makeTurn(direction);
        return direction.move(position);
    }

    private Position moveStraight() {
        return direction.move(position);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("position", position).add("direction", direction).add("nextTurn", nextTurn).toString();
    }

}

package nl.mwensveen.adventofcode.year_2018.day_13;

public enum Turn {
    LEFT(1),
    STRAIGHT(0),
    RIGHT(-1);

    private int directionIncrease;

    private Turn(int directionIncrease) {
        this.directionIncrease = directionIncrease;
    }

    public Direction makeTurn(Direction direction) {
        int next;
        if (direction == Direction.UP || direction == Direction.DOWN) {
            next = direction.ordinal() + directionIncrease;
        } else {
            next = direction.ordinal() - directionIncrease;
        }
        return Direction.values()[next > 3 ? 0 : next < 0 ? 3 : next];
    }

    public Direction makeTurnAtCrossing(Direction direction) {
        int next = direction.ordinal() + directionIncrease;
        return Direction.values()[next > 3 ? 0 : next < 0 ? 3 : next];
    }

    public Turn nextTurn() {
        int next = this.ordinal() + 1;
        return Turn.values()[next > 2 ? 0 : next];
    }
}

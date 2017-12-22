package nl.mwensveen.adventofcode.year_2017.day_22;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!getClass().equals(other.getClass())) {
            return false;
        }
        Coordinate castOther = (Coordinate) other;
        return Objects.equal(x, castOther.x) && Objects.equal(y, castOther.y);
    }

    public Coordinate move(Direction direction) {
        switch (direction) {
            case UP:
                return new Coordinate(x, y - 1);
            case RIGHT:
                return new Coordinate(x + 1, y);
            case DOWN:
                return new Coordinate(x, y + 1);
            case LEFT:
                return new Coordinate(x - 1, y);
            default:
                throw new RuntimeException();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("x", x).add("y", y).toString();
    }

}

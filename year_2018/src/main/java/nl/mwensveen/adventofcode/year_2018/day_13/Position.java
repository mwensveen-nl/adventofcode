package nl.mwensveen.adventofcode.year_2018.day_13;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Position implements Comparable<Position> {
    private int x;
    private int y;

    public Position(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Position)) {
            return false;
        }
        Position castOther = (Position) other;
        return Objects.equal(x, castOther.x) && Objects.equal(y, castOther.y);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("x", x).add("y", y).toString();
    }

    @Override
    public int compareTo(Position other) {
        int compare = Integer.compare(y, other.y);
        if (compare == 0) {
            return Integer.compare(x, other.x);
        }
        return compare;
    }

}

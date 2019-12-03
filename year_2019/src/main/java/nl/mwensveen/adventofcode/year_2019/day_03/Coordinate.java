package nl.mwensveen.adventofcode.year_2019.day_03;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Coordinate {
    private int x;
    private int y;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("x", x).add("y", y).toString();
    }

    // @Override
    // public boolean equals(final Object other) {
    // if (!(other instanceof Coordinate)) {
    // return false;
    // }
    // Coordinate castOther = (Coordinate) other;
    // return Objects.equal(x, castOther.x) && Objects.equal(y, castOther.y);
    // }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }

    public Coordinate(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

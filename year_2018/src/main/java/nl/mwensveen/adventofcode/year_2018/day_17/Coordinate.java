package nl.mwensveen.adventofcode.year_2018.day_17;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Coordinate)) {
            return false;
        }
        Coordinate castOther = (Coordinate) other;
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

    public Coordinate down() {
        return new Coordinate(x, y + 1);
    }

    public Coordinate left() {
        return new Coordinate(x - 1, y);
    }

    public Coordinate right() {
        return new Coordinate(x + 1, y);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("x", x).add("y", y).toString();
    }

}

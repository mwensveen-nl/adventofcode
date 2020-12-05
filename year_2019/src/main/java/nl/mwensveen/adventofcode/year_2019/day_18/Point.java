package nl.mwensveen.adventofcode.year_2019.day_18;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Point)) {
            return false;
        }
        Point castOther = (Point) other;
        return Objects.equal(x, castOther.x) && Objects.equal(y, castOther.y);
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

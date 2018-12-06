package nl.mwensveen.adventofcode.year_2018.day_6;

import com.google.common.base.Objects;

public class Coordinate {

    private final int id;
    private final int x;
    private final int y;
    private int area = 0;

    public Coordinate(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getArea() {
        return area;
    }

    public void addArea() {
        this.area++;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Coordinate)) {
            return false;
        }
        Coordinate castOther = (Coordinate) other;
        return Objects.equal(id, castOther.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}

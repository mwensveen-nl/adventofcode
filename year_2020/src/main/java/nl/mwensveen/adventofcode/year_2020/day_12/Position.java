package nl.mwensveen.adventofcode.year_2020.day_12;

import com.google.common.base.MoreObjects;

public class Position {
    private Direction direction = Direction.EAST;
    private int northSouth = 0;
    private int westEast = 0;

    public Position(int startNorthSouth, int startWestEast) {
        northSouth = startNorthSouth;
        westEast = startWestEast;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getNorthSouth() {
        return northSouth;
    }

    public void setNorthSouth(int northSouth) {
        this.northSouth = northSouth;
    }

    public int getWestEast() {
        return westEast;
    }

    public void setWestEast(int westEast) {
        this.westEast = westEast;
    }

    public void addNorthSouth(int value) {
        northSouth += value;
    }

    public void addWestEast(int value) {
        westEast += value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("direction", direction).add("northSouth", northSouth).add("westEast", westEast).toString();
    }

}
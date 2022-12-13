package nl.mwensveen.adventofcode.year_2022.day_12;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;

public class Coordinate {
    private final char elevation;
    private final Integer row;
    private final Integer col;
    private int steps = Integer.MAX_VALUE;
    private List<Coordinate> shortestPath = new ArrayList<>();

    public Coordinate(char elevation, Integer row, Integer col) {
        super();
        this.elevation = elevation;
        this.row = row;
        this.col = col;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }

    public char getElevation() {
        return elevation;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public List<Coordinate> getShortestPath() {
        return shortestPath;
    }

    public void addToShortestPath(Coordinate coordinate) {
        shortestPath.add(coordinate);
    }

    public void setShortestPath(List<Coordinate> shortestPath) {
        this.shortestPath = new ArrayList<>(shortestPath);
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Coordinate)) {
            return false;
        }
        Coordinate castOther = (Coordinate) other;
        return Objects.equal(row, castOther.row) && Objects.equal(col, castOther.col);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(row, col);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("elevation", elevation).add("row", row).add("col", col).toString();
    }
}

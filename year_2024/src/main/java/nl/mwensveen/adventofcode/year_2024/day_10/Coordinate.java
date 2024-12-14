package nl.mwensveen.adventofcode.year_2024.day_10;

public record Coordinate(long row, long col) {
    public Coordinate up() {
        return new Coordinate(row - 1, col);
    }

    public Coordinate right() {
        return new Coordinate(row, col + 1);
    }

    public Coordinate down() {
        return new Coordinate(row + 1, col);
    }

    public Coordinate left() {
        return new Coordinate(row, col - 1);
    }

}

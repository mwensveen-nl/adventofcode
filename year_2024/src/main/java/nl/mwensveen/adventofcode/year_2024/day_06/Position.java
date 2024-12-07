package nl.mwensveen.adventofcode.year_2024.day_06;

public record Position(
        int row,
        int col) {

    public Position step(Direction d) {
        return new Position(row + d.getRowModifier(), col + d.getColModifier());
    }
}

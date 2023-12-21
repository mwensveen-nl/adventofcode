package nl.mwensveen.adventofcode.year_2023.day_16;

public record Beam(Integer row, Integer col, Direction direction) {

    @Override
    public String toString() {
        return "Beam [" + row + ", " + col + ", " + direction + "]";
    }

}

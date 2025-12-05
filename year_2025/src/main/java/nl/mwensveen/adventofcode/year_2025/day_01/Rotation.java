package nl.mwensveen.adventofcode.year_2025.day_01;

public record Rotation(Direction direction, Integer count) {

    public Rotation(String input) {
        this(Direction.find(input.substring(0, 1)), Integer.valueOf(input.substring(1)));
    }
}

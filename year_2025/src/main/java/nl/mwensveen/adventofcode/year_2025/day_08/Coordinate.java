package nl.mwensveen.adventofcode.year_2025.day_08;

public record Coordinate(Integer x, Integer y, Integer z) {

    public Coordinate(String input) {
        this(Integer.valueOf(input.split(",")[0]), Integer.valueOf(input.split(",")[1]), Integer.valueOf(input.split(",")[2]));
    }
}

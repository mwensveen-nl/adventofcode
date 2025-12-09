package nl.mwensveen.adventofcode.year_2025.day_09;

public record Tile(int x, int y) {
    public Tile(String input) {
        this(Integer.parseInt(input.split(",")[0].trim()), Integer.parseInt(input.split(",")[1].trim()));
    }
}

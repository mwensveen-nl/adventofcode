package nl.mwensveen.adventofcode.year_2025.day_05;

public record IngredientRange(long start, long end) {

    public IngredientRange(String range) {
        this(Long.valueOf(range.substring(0, range.indexOf("-"))), Long.valueOf(range.substring(range.indexOf("-") + 1)));
    }

    public boolean inRange(long l) {
        return l >= start && l <= end;
    }

}

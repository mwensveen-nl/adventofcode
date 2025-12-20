package nl.mwensveen.adventofcode.year_2025.day_10;

public record IndicatorLight(String diagram, Integer bits) {
    public IndicatorLight(String diagram) {
        String conv = diagram.replace('.', '0').replace('#', '1');
        String rev = new StringBuilder(conv).reverse().toString();
        this(diagram, Integer.parseInt(rev, 2));
    }
}

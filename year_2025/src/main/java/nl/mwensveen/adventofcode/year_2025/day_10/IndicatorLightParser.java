package nl.mwensveen.adventofcode.year_2025.day_10;

public class IndicatorLightParser {

    public IndicatorLight parse(String input) {
        return new IndicatorLight(input.substring(1, input.length() - 1));
    }
}

package nl.mwensveen.adventofcode.year_2025.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IndicatorLightParserTest {

    @Test
    public void parse() {
        IndicatorLightParser parser = new IndicatorLightParser();
        IndicatorLight indicatorLight = parser.parse("[.##.]");
        assertEquals(6, indicatorLight.bits());

    }

}

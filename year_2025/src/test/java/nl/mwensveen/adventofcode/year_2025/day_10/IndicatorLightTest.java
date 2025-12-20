package nl.mwensveen.adventofcode.year_2025.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IndicatorLightTest {

    @Test
    public void indicatorLightTest() {
        assertEquals(6, new IndicatorLight(".##.").bits());
        assertEquals(8, new IndicatorLight("...#.").bits());
    }

}

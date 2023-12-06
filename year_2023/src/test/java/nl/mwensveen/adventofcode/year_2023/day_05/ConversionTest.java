package nl.mwensveen.adventofcode.year_2023.day_05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionTest {

    @Test
    public void testParse() {
        Conversion conversion = Conversion.parse("temperature-to-humidity map:");
        assertEquals("temperature", conversion.source());
        assertEquals("humidity", conversion.destination());

    }

    @Test
    public void testAddRange() {
        Conversion conversion = Conversion.parse("temperature-to-humidity map:");
        conversion.addRange("1368371614 3063096196 39876417");
        ConversionRange conversionRange = conversion.conversionRanges().get(0);

        assertEquals(1368371614L, conversionRange.destinationStart());
        assertEquals(3063096196L, conversionRange.sourceStart());
        assertEquals(39876417L, conversionRange.range());
    }

}

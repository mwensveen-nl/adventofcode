package nl.mwensveen.adventofcode.year_2023.day_05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlmanacSeedsTest {

    @Test
    public void testParse() {
        AlmanacSeeds almanac = AlmanacSeeds.parse("seeds: 79 14 55 13");
        assertEquals(4, almanac.seeds().size());
        assertTrue(almanac.seeds().contains(79L));
        assertTrue(almanac.seeds().contains(14L));
        assertTrue(almanac.seeds().contains(55L));
        assertTrue(almanac.seeds().contains(13L));
    }

}

package nl.mwensveen.adventofcode.year_2019.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MoonParserTest {

    @Test
    public void testParseMoons() throws Exception {
        MoonParser moonParser = new MoonParser();
        String input = "<x=-1, y=0, z=2>\n" + "<x=2, y=-10, z=-7>\n" + "<x=4, y=-8, z=8>\n" + "<x=3, y=5, z=-1>";
        List<Moon> moons = moonParser.parseMoons(Arrays.asList(input.split("\n")));
        assertEquals(4, moons.size());
        assertEquals(-1, moons.get(0).getPositionX());
        assertEquals(0, moons.get(0).getPositionY());
        assertEquals(2, moons.get(0).getPositionZ());
    }

}

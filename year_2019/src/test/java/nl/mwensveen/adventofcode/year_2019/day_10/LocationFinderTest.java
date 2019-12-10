package nl.mwensveen.adventofcode.year_2019.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LocationFinderTest {

    @Test
    public void testFindLocation() throws Exception {
        List<String> input = new ArrayList<>();
        input.add(new String(".#..#"));
        input.add(new String("....."));
        input.add(new String("#####"));
        input.add(new String("....#"));
        input.add(new String("...##"));
        LocationFinder locationFinder = new LocationFinder();
        Asteroid asteroid = locationFinder.findLocation(input);
        assertEquals(3, asteroid.getPoint().getX());
        assertEquals(4, asteroid.getPoint().getY());

    }

    @Test
    public void testFindLocation2() throws Exception {
        List<String> input = new ArrayList<>();
        input.add(new String("......#.#."));
        input.add(new String("#..#.#...."));
        input.add(new String("..#######."));
        input.add(new String(".#.#.###.."));
        input.add(new String(".#..#....."));
        input.add(new String("..#....#.#"));
        input.add(new String("#..#....#."));
        input.add(new String(".##.#..###"));
        input.add(new String("##...#..#."));
        input.add(new String(".#....####"));
        LocationFinder locationFinder = new LocationFinder();
        Asteroid asteroid = locationFinder.findLocation(input);
        assertEquals(5, asteroid.getPoint().getX());
        assertEquals(8, asteroid.getPoint().getY());
    }
}

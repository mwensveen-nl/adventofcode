package nl.mwensveen.adventofcode.year_2019.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AsteroidMapperTest {

    @Test
    public void testMapAsteroids() throws Exception {
        List<String> input = new ArrayList<>();
        input.add("..#..");
        input.add(".#.#");
        AsteroidMapper mapper = new AsteroidMapper();
        List<Asteroid> asteroids = mapper.mapAsteroids(input);
        assertEquals(3, asteroids.size());
        assertEquals(new Point(2, 0), asteroids.get(0).getPoint());
        assertEquals(new Point(1, 1), asteroids.get(1).getPoint());
        assertEquals(new Point(3, 1), asteroids.get(2).getPoint());
    }

}

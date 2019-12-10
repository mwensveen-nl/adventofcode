package nl.mwensveen.adventofcode.year_2019.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AsteroidMapProcessorTest {

    @Test
    public void testFindLocation() throws Exception {
        List<String> input = new ArrayList<>();
        input.add(new String(".#..#"));
        input.add(new String("....."));
        input.add(new String("#####"));
        input.add(new String("....#"));
        input.add(new String("...##"));
        AsteroidMapProcessor processor = new AsteroidMapProcessor();
        Asteroid asteroid = processor.findLocation(input);
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
        AsteroidMapProcessor processor = new AsteroidMapProcessor();
        Asteroid asteroid = processor.findLocation(input);
        assertEquals(5, asteroid.getPoint().getX());
        assertEquals(8, asteroid.getPoint().getY());
    }

    @Test
    public void testFindLocation3() throws Exception {
        List<String> input = new ArrayList<>();
        input.add(new String("#.#...#.#."));
        input.add(new String(".###....#."));
        input.add(new String(".#....#..."));
        input.add(new String("##.#.#.#.#"));
        input.add(new String("....#.#.#."));
        input.add(new String(".##..###.#"));
        input.add(new String("..#...##.."));
        input.add(new String("..##....##"));
        input.add(new String("......#..."));
        input.add(new String(".####.###."));
        AsteroidMapProcessor processor = new AsteroidMapProcessor();
        Asteroid asteroid = processor.findLocation(input);
        assertEquals(1, asteroid.getPoint().getX());
        assertEquals(2, asteroid.getPoint().getY());
    }

    @Test
    public void testFindLocation4() throws Exception {
        List<String> input = new ArrayList<>();
        input.add(new String(".#..#..###"));
        input.add(new String("####.###.#"));
        input.add(new String("....###.#."));
        input.add(new String("..###.##.#"));
        input.add(new String("##.##.#.#."));
        input.add(new String("....###..#"));
        input.add(new String("..#.#..#.#"));
        input.add(new String("#..#.#.###"));
        input.add(new String(".##...##.#"));
        input.add(new String(".....#.#.."));
        AsteroidMapProcessor processor = new AsteroidMapProcessor();
        Asteroid asteroid = processor.findLocation(input);
        assertEquals(6, asteroid.getPoint().getX());
        assertEquals(3, asteroid.getPoint().getY());
    }

    @Test
    public void testFindLocation5() throws Exception {
        List<String> input = new ArrayList<>();
        input.add(new String(".#..##.###...#######"));
        input.add(new String("##.############..##."));
        input.add(new String(".#.######.########.#"));
        input.add(new String(".###.#######.####.#."));
        input.add(new String("#####.##.#.##.###.##"));
        input.add(new String("..#####..#.#########"));
        input.add(new String("####################"));
        input.add(new String("#.####....###.#.#.##"));
        input.add(new String("##.#################"));
        input.add(new String("#####.##.###..####.."));
        input.add(new String("..######..##.#######"));
        input.add(new String("####.##.####...##..#"));
        input.add(new String(".#####..#.######.###"));
        input.add(new String("##...#.##########..."));
        input.add(new String("#.##########.#######"));
        input.add(new String(".####.#.###.###.#.##"));
        input.add(new String("....##.##.###..#####"));
        input.add(new String(".#.#.###########.###"));
        input.add(new String("#.#.#.#####.####.###"));
        input.add(new String("###.##.####.##.#..##"));
        AsteroidMapProcessor processor = new AsteroidMapProcessor();
        Asteroid asteroid = processor.findLocation(input);
        assertEquals(11, asteroid.getPoint().getX());
        assertEquals(13, asteroid.getPoint().getY());
    }

    @Test
    public void testVaporizeAsteroids() throws Exception {
        List<String> input = new ArrayList<>();
        input.add(new String(".#..##.###...#######"));
        input.add(new String("##.############..##."));
        input.add(new String(".#.######.########.#"));
        input.add(new String(".###.#######.####.#."));
        input.add(new String("#####.##.#.##.###.##"));
        input.add(new String("..#####..#.#########"));
        input.add(new String("####################"));
        input.add(new String("#.####....###.#.#.##"));
        input.add(new String("##.#################"));
        input.add(new String("#####.##.###..####.."));
        input.add(new String("..######..##.#######"));
        input.add(new String("####.##.####...##..#"));
        input.add(new String(".#####..#.######.###"));
        input.add(new String("##...#.##########..."));
        input.add(new String("#.##########.#######"));
        input.add(new String(".####.#.###.###.#.##"));
        input.add(new String("....##.##.###..#####"));
        input.add(new String(".#.#.###########.###"));
        input.add(new String("#.#.#.#####.####.###"));
        input.add(new String("###.##.####.##.#..##"));
        AsteroidMapProcessor processor = new AsteroidMapProcessor();
        Asteroid asteroid = processor.findLocation(input);
        assertEquals(11, asteroid.getPoint().getX());
        assertEquals(13, asteroid.getPoint().getY());

        List<Asteroid> asteroids = processor.vaporizeAsteroids(asteroid);
        assertEquals(11, asteroids.get(0).getPoint().getX());
        assertEquals(12, asteroids.get(0).getPoint().getY());

        assertEquals(12, asteroids.get(1).getPoint().getX());
        assertEquals(1, asteroids.get(1).getPoint().getY());

        assertEquals(12, asteroids.get(2).getPoint().getX());
        assertEquals(2, asteroids.get(2).getPoint().getY());

        assertEquals(12, asteroids.get(9).getPoint().getX());
        assertEquals(8, asteroids.get(9).getPoint().getY());

        assertEquals(16, asteroids.get(19).getPoint().getX());
        assertEquals(0, asteroids.get(19).getPoint().getY());

        assertEquals(16, asteroids.get(49).getPoint().getX());
        assertEquals(9, asteroids.get(49).getPoint().getY());

        assertEquals(10, asteroids.get(99).getPoint().getX());
        assertEquals(16, asteroids.get(99).getPoint().getY());

        assertEquals(9, asteroids.get(198).getPoint().getX());
        assertEquals(6, asteroids.get(198).getPoint().getY());

        assertEquals(8, asteroids.get(199).getPoint().getX());
        assertEquals(2, asteroids.get(199).getPoint().getY());

        assertEquals(10, asteroids.get(200).getPoint().getX());
        assertEquals(9, asteroids.get(200).getPoint().getY());

        assertEquals(11, asteroids.get(298).getPoint().getX());
        assertEquals(1, asteroids.get(298).getPoint().getY());

    }
}

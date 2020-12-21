package nl.mwensveen.adventofcode.year_2020.day_20;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SeamonsterSearcherTest {

    @Test
    public void testFindSeamonster() throws Exception {
        List<String> input = Arrays.asList("Tile 1", ".#.#...#.###...#.##.##..", "#.#.##.###.#.##.##.#####", "..##.###.####..#.####.##");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);

        SeamonsterSearcher seamonsterSearcher = new SeamonsterSearcher();
        boolean result = seamonsterSearcher.findSeamonster(image);
        assertTrue(result);
    }

    @Test
    public void testFindSeamonster2() throws Exception {
        List<String> input =
                Arrays.asList("Tile 2", ".#.#...#.###...#.##.##..", ".#.#...#.###...#.##.##..", "#.#.##.###.#.##.##.#####", "..##.###.####..#.####.##");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);

        SeamonsterSearcher seamonsterSearcher = new SeamonsterSearcher();
        boolean result = seamonsterSearcher.findSeamonster(image);
        assertTrue(result);
    }

    @Test
    public void testFindSeamonster6() throws Exception {
        List<String> input = Arrays.asList("Tile 6", ".#.#...#.###...#.##.##...#.#...#.###...#.##.##..", "#.#.##.###.#.##.##.######.#.##.###.#.##.##.#####",
                "..#..###.####..#.####.##..##.###.####..#.####.##");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);

        SeamonsterSearcher seamonsterSearcher = new SeamonsterSearcher();
        boolean result = seamonsterSearcher.findSeamonster(image);
        assertTrue(result);
    }

    @Test
    public void testFindSeamonster3() throws Exception {
        List<String> input =
                Arrays.asList("Tile 3", ".#.#...#.###...#.##.##..", ".#.#...#.###...#.##.##..", "#.#.##.###.#.##.##..####", "..##.###.####..#.####.##");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);

        SeamonsterSearcher seamonsterSearcher = new SeamonsterSearcher();
        boolean result = seamonsterSearcher.findSeamonster(image);
        assertFalse(result);
    }

    @Test
    public void testFindSeamonster4() throws Exception {
        List<String> input =
                Arrays.asList("Tile 4", ".#.#...#.###...#.##.##..", ".#.#...#.###...#.##..#..", "#.#.##.###.#.##.##..####", "..##.###.####..#.####.##");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);

        SeamonsterSearcher seamonsterSearcher = new SeamonsterSearcher();
        boolean result = seamonsterSearcher.findSeamonster(image);
        assertFalse(result);
    }

    @Test
    public void testFindSeamonster5() throws Exception {
        List<String> input =
                Arrays.asList("Tile 5", ".#.#...#.###...#.##.##..", ".#.#...#.###...#.##.##..", "#.#.##.###.#.##.##.#####", "..##.###..###..#.####.##");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);

        SeamonsterSearcher seamonsterSearcher = new SeamonsterSearcher();
        boolean result = seamonsterSearcher.findSeamonster(image);
        assertFalse(result);
    }

}

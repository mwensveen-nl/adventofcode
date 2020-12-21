package nl.mwensveen.adventofcode.year_2020.day_20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SeamonsterProcessorTest {

    @Test
    public void testCountInRow() throws Exception {
        List<String> input = Arrays.asList("Tile 2", ".#.#..#.##...#.##..#####", "###....#.#....#..#......", "##.##.###.#.#..######...",
                "###.#####...#.#####.#..#", "##.#....#.##.####...#.##", "...########.#....#####.#", "....#..#...##..#.#.###..", ".####...#..#.....#......",
                "#..#.##..#..###.#.##....", "#.####..#.####.#.#.###..", "###.#.#...#.######.#..##", "#.####....##..########.#", "##..##.#...#...#.#.#.#..",
                "...#..#..#.#.##..###.###", ".#.#....#.##.#...###.##.", "###.#...#..#.##.######..", ".#.#.###.##.##.#..#.##..", ".####.###.#...###.#..#.#",
                "..#.#..#..#.#.#.####.###", "#..####...#.#.#.###.###.", "#####..#####...###....##", "#.##..#..#...#..####...#", ".#.###..##..##..####.##.",
                "...###...##...#...#..###");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);

        SeamonsterProcessor seamonsterProcessor = new SeamonsterProcessor();
        int result = seamonsterProcessor.processSeamonsterInImage(image);
        assertEquals(273, result);
    }

}

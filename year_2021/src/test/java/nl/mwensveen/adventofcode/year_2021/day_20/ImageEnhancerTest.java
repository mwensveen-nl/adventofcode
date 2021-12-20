package nl.mwensveen.adventofcode.year_2021.day_20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ImageEnhancerTest {

    @Test
    public void testEnhanceImage() {
        List<String> input = Arrays.asList(
                "..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..###..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###.######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#..#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#......#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#.....####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#.......##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#",
                "",
                "#..#.",
                "#....",
                "##..#",
                "..#..",
                "..###");
        ImageEnhancer enhancer = new ImageEnhancer();
        long result = enhancer.enhanceImage(input, 2);
        assertEquals(35, result);
    }

}

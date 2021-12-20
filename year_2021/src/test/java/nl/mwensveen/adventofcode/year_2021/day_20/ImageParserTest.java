package nl.mwensveen.adventofcode.year_2021.day_20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ImageParserTest {

    @Test
    public void testParseImage() {
        List<String> input = Arrays.asList(
                "..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..###..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###.######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#..#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#......#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#.....####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#.......##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#",
                "",
                "#..#.",
                "#....",
                "##..#",
                "..#..",
                "..###");
        ImageParser imageParser = new ImageParser();
        Table<Integer, Integer, Pixel> result = imageParser.parseImage(input);
        assertEquals("#", result.get(0, 0).getSymbol());
        assertEquals(".", result.get(0, 4).getSymbol());
        assertEquals(".", result.get(4, 0).getSymbol());
        assertEquals("#", result.get(4, 4).getSymbol());
    }

    @Test
    public void testParseImageEnhancementAlgorithm() {
        List<String> input = Arrays.asList(
                "..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..###..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###.######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#..#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#......#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#.....####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#.......##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#",
                "",
                "#..#.",
                "#....",
                "##..#",
                "..#..",
                "..###");
        ImageParser imageParser = new ImageParser();
        List<String> result = imageParser.parseImageEnhancementAlgorithm(input);
        assertEquals(".", result.get(0));
        assertEquals("#", result.get(511));

    }

}

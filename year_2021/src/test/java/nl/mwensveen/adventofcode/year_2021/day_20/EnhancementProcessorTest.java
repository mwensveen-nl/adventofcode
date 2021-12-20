package nl.mwensveen.adventofcode.year_2021.day_20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class EnhancementProcessorTest {

    @Test
    public void testEnhance() {
        List<String> input = Arrays.asList(
                "..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..###..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###.######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#..#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#......#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#.....####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#.......##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#",
                "",
                "#..#.",
                "#....",
                "##..#",
                "..#..",
                "..###");
        ImageParser imageParser = new ImageParser();
        Table<Integer, Integer, Pixel> image = imageParser.parseImage(input);
        List<String> imageEnhancementAlgorithm = imageParser.parseImageEnhancementAlgorithm(input);
        ImageDimension dimension = new ImageDimension(image);

        EnhancementProcessor enhancementProcessor = new EnhancementProcessor();
        image = enhancementProcessor.enhance(image, dimension, imageEnhancementAlgorithm, ".");
        image = enhancementProcessor.enhance(image, dimension, imageEnhancementAlgorithm, ".");
        assertEquals(".", image.get(-2, -2).getSymbol());
        assertEquals(".", image.get(-2, -1).getSymbol());
        assertEquals(".", image.get(-2, 0).getSymbol());
        assertEquals(".", image.get(-2, 1).getSymbol());
        assertEquals(".", image.get(-2, 2).getSymbol());
        assertEquals(".", image.get(-2, 3).getSymbol());
        assertEquals(".", image.get(-2, 4).getSymbol());
        assertEquals("#", image.get(-2, 5).getSymbol());
        assertEquals(".", image.get(-2, 6).getSymbol());

        assertEquals(".", image.get(6, -2).getSymbol());
        assertEquals(".", image.get(6, -1).getSymbol());
        assertEquals(".", image.get(6, 0).getSymbol());
        assertEquals(".", image.get(6, 1).getSymbol());
        assertEquals("#", image.get(6, 2).getSymbol());
        assertEquals("#", image.get(6, 3).getSymbol());
        assertEquals("#", image.get(6, 4).getSymbol());
        assertEquals(".", image.get(6, 5).getSymbol());
        assertEquals(".", image.get(6, 6).getSymbol());

        assertEquals(-2, dimension.getMinRow());
        assertEquals(6, dimension.getMaxRow());
        assertEquals(-2, dimension.getMinColumn());
        assertEquals(6, dimension.getMaxColumn());
    }

}

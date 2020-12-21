package nl.mwensveen.adventofcode.year_2020.day_20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImageMergerTest {
    public static final List<String> INPUT = Arrays.asList("Tile 2311:", "..##.#..#.", "##..#.....", "#...##..#.", "####.#...#", "##.##.###.", "##...#.###",
            ".#.#.#..##", "..#....#..", "###...#.#.", "..###..###", "", "Tile 1951:", "#.##...##.", "#.####...#", ".....#..##", "#...######", ".##.#....#",
            ".###.#####", "###.##.##.", ".###....#.", "..#.#..#.#", "#...##.#..", "", "Tile 1171:", "####...##.", "#..##.#..#", "##.#..#.#.", ".###.####.",
            "..###.####", ".##....##.", ".#...####.", "#.##.####.", "####..#...", ".....##...", "", "Tile 1427:", "###.##.#..", ".#..#.##..", ".#.##.#..#",
            "#.#.#.##.#", "....#...##", "...##..##.", "...#.#####", ".#.####.#.", "..#..###.#", "..##.#..#.", "", "Tile 1489:", "##.#.#....", "..##...#..",
            ".##..##...", "..#...#...", "#####...#.", "#..#.#.#.#", "...#.#.#..", "##.#...##.", "..##.##.##", "###.##.#..", "", "Tile 2473:", "#....####.",
            "#..#.##...", "#.##..#...", "######.#.#", ".#...#.#.#", ".#########", ".###.#..#.", "########.#", "##...##.#.", "..###.#.#.", "", "Tile 2971:",
            "..#.#....#", "#...###...", "#.#.###...", "##.##..#..", ".#####..##", ".#..####.#", "#..#.#..#.", "..####.###", "..#.#.###.", "...#.#.#.#", "",
            "Tile 2729:", "...#.#.#.#", "####.#....", "..#.#.....", "....#..#.#", ".##..##.#.", ".#.####...", "####.#.#..", "##.####...", "##..#.##..",
            "#.##...##.", "", "Tile 3079:", "#.#.#####.", ".#..######", "..#.......", "######....", "####.#..#.", ".#...#.##.", "#.#####.##", "..#.###...",
            "..#.......", "..#.###...");
    private List<Image> images;

    @BeforeEach
    public void testParse() throws Exception {
        InputParser inputParser = new InputParser();
        images = inputParser.parse(INPUT);
    }

    @Test
    public void testMerge() throws Exception {
        ImageArranger imageArranger = new ImageArranger();
        Grid grid = imageArranger.arrange(images);
        ImageMerger imageMerger = new ImageMerger();
        Image newImage = imageMerger.merge(grid);
        // match rotation and flip from the site.
        newImage.rotate();
        newImage.rotate();
        newImage.flip();
        assertEquals(".#.#..#.##...#.##..#####", newImage.getRow(0));
        assertEquals("###....#.#....#..#......", newImage.getRow(1));
        assertEquals("##.##.###.#.#..######...", newImage.getRow(2));
        assertEquals("###.#####...#.#####.#..#", newImage.getRow(3));
        assertEquals("##.#....#.##.####...#.##", newImage.getRow(4));
        assertEquals("...########.#....#####.#", newImage.getRow(5));
        assertEquals("....#..#...##..#.#.###..", newImage.getRow(6));
        assertEquals(".####...#..#.....#......", newImage.getRow(7));
        assertEquals("#..#.##..#..###.#.##....", newImage.getRow(8));
        assertEquals("#.####..#.####.#.#.###..", newImage.getRow(9));
        assertEquals("###.#.#...#.######.#..##", newImage.getRow(10));
        assertEquals("#.####....##..########.#", newImage.getRow(11));
        assertEquals("##..##.#...#...#.#.#.#..", newImage.getRow(12));
        assertEquals("...#..#..#.#.##..###.###", newImage.getRow(13));
        assertEquals(".#.#....#.##.#...###.##.", newImage.getRow(14));
        assertEquals("###.#...#..#.##.######..", newImage.getRow(15));
        assertEquals(".#.#.###.##.##.#..#.##..", newImage.getRow(16));
        assertEquals(".####.###.#...###.#..#.#", newImage.getRow(17));
        assertEquals("..#.#..#..#.#.#.####.###", newImage.getRow(18));
        assertEquals("#..####...#.#.#.###.###.", newImage.getRow(19));
        assertEquals("#####..#####...###....##", newImage.getRow(20));
        assertEquals("#.##..#..#...#..####...#", newImage.getRow(21));
        assertEquals(".#.###..##..##..####.##.", newImage.getRow(22));
        assertEquals("...###...##...#...#..###", newImage.getRow(23));
    }

}

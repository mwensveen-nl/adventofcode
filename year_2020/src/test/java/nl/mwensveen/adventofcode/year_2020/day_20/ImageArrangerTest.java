package nl.mwensveen.adventofcode.year_2020.day_20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImageArrangerTest {

    public static final List<String> INPUT = Arrays.asList(
            "Tile 2311:", "..##.#..#.", "##..#.....", "#...##..#.", "####.#...#", "##.##.###.", "##...#.###", ".#.#.#..##", "..#....#..", "###...#.#.",
            "..###..###", "", "Tile 1951:", "#.##...##.", "#.####...#", ".....#..##", "#...######", ".##.#....#", ".###.#####", "###.##.##.", ".###....#.",
            "..#.#..#.#", "#...##.#..", "", "Tile 1171:", "####...##.", "#..##.#..#", "##.#..#.#.", ".###.####.", "..###.####", ".##....##.", ".#...####.",
            "#.##.####.", "####..#...", ".....##...", "", "Tile 1427:", "###.##.#..", ".#..#.##..", ".#.##.#..#", "#.#.#.##.#", "....#...##", "...##..##.",
            "...#.#####", ".#.####.#.", "..#..###.#", "..##.#..#.", "", "Tile 1489:", "##.#.#....", "..##...#..", ".##..##...", "..#...#...", "#####...#.",
            "#..#.#.#.#", "...#.#.#..", "##.#...##.", "..##.##.##", "###.##.#..", "", "Tile 2473:", "#....####.", "#..#.##...", "#.##..#...", "######.#.#",
            ".#...#.#.#", ".#########", ".###.#..#.", "########.#", "##...##.#.", "..###.#.#.", "", "Tile 2971:", "..#.#....#", "#...###...", "#.#.###...",
            "##.##..#..", ".#####..##", ".#..####.#", "#..#.#..#.", "..####.###", "..#.#.###.", "...#.#.#.#", "", "Tile 2729:", "...#.#.#.#", "####.#....",
            "..#.#.....", "....#..#.#", ".##..##.#.", ".#.####...", "####.#.#..", "##.####...", "##..#.##..", "#.##...##.", "", "Tile 3079:", "#.#.#####.",
            ".#..######", "..#.......", "######....", "####.#..#.", ".#...#.##.", "#.#####.##", "..#.###...", "..#.......", "..#.###...");
    private List<Image> images;

    @BeforeEach
    public void testParse() throws Exception {
        InputParser inputParser = new InputParser();
        images = inputParser.parse(INPUT);
    }

    @Test
    public void testArrange() throws Exception {
        ImageArranger imageArranger = new ImageArranger();
        images.get(0);
        Grid result = imageArranger.arrange(images);
        Image image1 = result.get(result.getMinX(), result.getMinY());
        Image image2 = result.get(result.getMinX(), result.getMaxY());
        Image image3 = result.get(result.getMaxX(), result.getMaxY());
        Image image4 = result.get(result.getMaxX(), result.getMinY());
        Long id1 = Long.valueOf(image1.getId());
        Long id2 = Long.valueOf(image2.getId());
        Long id3 = Long.valueOf(image3.getId());
        Long id4 = Long.valueOf(image4.getId());
        assertEquals(20899048083289L, id1 * id2 * id3 * id4);
    }

}

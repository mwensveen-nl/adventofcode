package nl.mwensveen.adventofcode.year_2020.day_20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SeamonsterReplacerTest {

    @Test
    public void testReplaceSeamonsterImage() throws Exception {
        List<String> input = Arrays.asList("Tile 1", ".#.#...#.###...#.##.##..", "#.#.##.###.#.##.##.#####", "..##.###.####..#.####.##");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);

        SeamonsterReplacer seamonsterReplacer = new SeamonsterReplacer();
        List<String> result = seamonsterReplacer.replaceSeamonster(image);
        List<String> expected = Arrays.asList(".#.#...#.###...#.##.O#..", "#.O.##.OO#.#.OO.##.OOO##", "..#O.#O#.O##O..O.#O##.##");
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceSeamonsterImage2() throws Exception {
        List<String> input = Arrays.asList("Tile 2", ".####...#####..#...###..", "#####..#..#.#.####..#.#.", ".#.#...#.###...#.##.##..",
                "#.#.##.###.#.##.##.#####", "..##.###.####..#.####.##", "...#.#..##.##...#..#..##", "#.##.#..#.#..#..##.#.#..", ".###.##.....#...###.#...",
                "#.####.#.#....##.#..#.#.", "##...#..#....#..#...####", "..#.##...###..#.#####..#", "....#.##.#.#####....#...", "..##.##.###.....#.##..#.",
                "#...#...###..####....##.", ".#.##...#.##.#.#.###...#", "#.###.#..####...##..#...", "#.###...#.##...#.######.", ".###.###.#######..#####.",
                "..##.#..#..#.#######.###", "#.#..##.########..#..##.", "#.#####..#.#...##..#....", "#....##..#.#########..##", "#...#.....#..##...###.##",
                "#..###....##.#...##.##.#");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);

        SeamonsterReplacer seamonsterReplacer = new SeamonsterReplacer();
        List<String> result = seamonsterReplacer.replaceSeamonster(image);
        List<String> expected = Arrays.asList(".####...#####..#...###..", "#####..#..#.#.####..#.#.", ".#.#...#.###...#.##.O#..", "#.O.##.OO#.#.OO.##.OOO##",
                "..#O.#O#.O##O..O.#O##.##", "...#.#..##.##...#..#..##", "#.##.#..#.#..#..##.#.#..", ".###.##.....#...###.#...", "#.####.#.#....##.#..#.#.",
                "##...#..#....#..#...####", "..#.##...###..#.#####..#", "....#.##.#.#####....#...", "..##.##.###.....#.##..#.", "#...#...###..####....##.",
                ".#.##...#.##.#.#.###...#", "#.###.#..####...##..#...", "#.###...#.##...#.##O###.", ".O##.#OO.###OO##..OOO##.", "..O#.O..O..O.#O##O##.###",
                "#.#..##.########..#..##.", "#.#####..#.#...##..#....", "#....##..#.#########..##", "#...#.....#..##...###.##", "#..###....##.#...##.##.#");
        assertEquals(expected, result);
    }

}

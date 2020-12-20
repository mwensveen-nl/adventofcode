package nl.mwensveen.adventofcode.year_2020.day_20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ImageParserTest {

    @Test
    public void testParser() throws Exception {
        List<String> input = Arrays.asList("Tile 2311:",
                "..##.#..#.",
                "##..#.....",
                "#...##..#.",
                "####.#...#",
                "##.##.###.",
                "##...#.###",
                ".#.#.#..##",
                "..#....#..",
                "###...#.#.",
                "..###..###");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);
        assertEquals("2311", image.getId());
        assertEquals("..##.#..#.", image.getRow(0));
        assertEquals("##..#.....", image.getRow(1));
        assertEquals("#...##..#.", image.getRow(2));
        assertEquals("####.#...#", image.getRow(3));
        assertEquals("##.##.###.", image.getRow(4));
        assertEquals("##...#.###", image.getRow(5));
        assertEquals(".#.#.#..##", image.getRow(6));
        assertEquals("..#....#..", image.getRow(7));
        assertEquals("###...#.#.", image.getRow(8));
        assertEquals("..###..###", image.getRow(9));

        assertEquals(".#####..#.", image.getColumn(0));
    }

    @Test
    public void testParser2() throws Exception {
        List<String> input = Arrays.asList("Tile 2311:",
                "ABC",
                "DEF",
                "GHI");
        ImageParser imageParser = new ImageParser();
        Image image = imageParser.parser(input);
        // R=0
        assertEquals("2311", image.getId());
        assertEquals("ABC", image.getRow(0));
        assertEquals("DEF", image.getRow(1));
        assertEquals("GHI", image.getRow(2));

        assertEquals("ADG", image.getColumn(0));
        assertEquals("BEH", image.getColumn(1));
        assertEquals("CFI", image.getColumn(2));

        image.rotate();
        // R=1
        assertEquals("GDA", image.getRow(0));
        assertEquals("GHI", image.getColumn(0));

        image.rotate();
        // R=2
        assertEquals("IHG", image.getRow(0));
        assertEquals("IFC", image.getColumn(0));

        image.rotate();
        // R=3
        assertEquals("CFI", image.getRow(0));
        assertEquals("CBA", image.getColumn(0));

        image.rotate();
        // R=0
        assertEquals("ABC", image.getRow(0));
        assertEquals("ADG", image.getColumn(0));

        image.flip();
        // R=0
        assertEquals("CBA", image.getRow(0));
        assertEquals("FED", image.getRow(1));
        assertEquals("IHG", image.getRow(2));

        assertEquals("CFI", image.getColumn(0));
        assertEquals("BEH", image.getColumn(1));
        assertEquals("ADG", image.getColumn(2));

        image.rotate();
        // R=1
        assertEquals("IFC", image.getRow(0));
        assertEquals("IHG", image.getColumn(0));

        image.rotate();
        // R=2
        assertEquals("GHI", image.getRow(0));
        assertEquals("GDA", image.getColumn(0));

        image.rotate();
        // R=3
        assertEquals("ADG", image.getRow(0));
        assertEquals("ABC", image.getColumn(0));

        image.rotate();
        image.flip();
        assertEquals("ABC", image.getRow(0));
        assertEquals("ADG", image.getColumn(0));

    }
}
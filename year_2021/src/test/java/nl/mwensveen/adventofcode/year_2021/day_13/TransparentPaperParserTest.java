package nl.mwensveen.adventofcode.year_2021.day_13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TransparentPaperParserTest {

    @Test
    public void testParsePaper() {
        List<String> input = Arrays.asList("6,10",
                "0,14",
                "9,10",
                "0,3",
                "10,4",
                "4,11",
                "6,0",
                "6,12",
                "4,1",
                "0,13",
                "10,12",
                "3,4",
                "3,0",
                "8,4",
                "1,10",
                "2,14",
                "8,10",
                "9,0",
                "",
                "fold along y=7",
                "fold along x=5");
        TransparentPaperParser transparentPaperParser = new TransparentPaperParser();
        Table<Integer, Integer, Character> paper = transparentPaperParser.parsePaper(input);

        assertTrue(paper.contains(10, 6));
        assertTrue(paper.contains(14, 0));
        assertTrue(paper.contains(0, 9));
        assertEquals(18, paper.values().size());
    }

    @Test
    public void testParseInstructions() {
        List<String> input = Arrays.asList("6,10",
                "0,14",
                "9,10",
                "0,3",
                "10,4",
                "4,11",
                "6,0",
                "6,12",
                "4,1",
                "0,13",
                "10,12",
                "3,4",
                "3,0",
                "8,4",
                "1,10",
                "2,14",
                "8,10",
                "9,0",
                "",
                "fold along y=7",
                "fold along x=5");
        TransparentPaperParser transparentPaperParser = new TransparentPaperParser();

        List<String> instructions = transparentPaperParser.parseInstructions(input);
        assertEquals(2, instructions.size());
        assertEquals("fold along y=7", instructions.get(0));
        assertEquals("fold along x=5", instructions.get(1));
    }
}

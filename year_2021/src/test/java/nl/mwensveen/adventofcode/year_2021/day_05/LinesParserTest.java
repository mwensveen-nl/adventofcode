package nl.mwensveen.adventofcode.year_2021.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LinesParserTest {

    @Test
    public void testParsLines() {
        List<String> input = Arrays.asList("0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2");
        LinesParser linesParser = new LinesParser();
        List<Line> lines = linesParser.parsLines(input);
        assertEquals(10, lines.size());
        Line line = lines.get(0);
        assertEquals(0, line.x1());
        assertEquals(9, line.y1());
        assertEquals(5, line.x2());
        assertEquals(9, line.y2());
        assertTrue(line.isVertical());

        line = lines.get(1);
        assertFalse(line.isVertical());
        assertFalse(line.isHorizontal());

        line = lines.get(3);
        assertEquals(2, line.x1());
        assertEquals(2, line.y1());
        assertEquals(2, line.x2());
        assertEquals(1, line.y2());
        assertTrue(line.isHorizontal());
    }

}

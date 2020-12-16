package nl.mwensveen.adventofcode.year_2020.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class FieldParserTest {

    @Test
    public void testParse() throws Exception {
        FieldParser parser = new FieldParser();
        Field field = parser.parse("class: 1-3 or 5-7");
        assertEquals("class", field.getName());
        List<Range> ranges = field.getRanges();
        assertEquals(2, ranges.size());
        assertEquals(1, ranges.get(0).getMin());
        assertEquals(3, ranges.get(0).getMax());
        assertEquals(5, ranges.get(1).getMin());
        assertEquals(7, ranges.get(1).getMax());
    }

    @Test
    public void testParse2() throws Exception {
        FieldParser parser = new FieldParser();
        Field field = parser.parse("departure location: 49-848 or 871-949");
        assertEquals("departure location", field.getName());
        List<Range> ranges = field.getRanges();
        assertEquals(2, ranges.size());
        assertEquals(49, ranges.get(0).getMin());
        assertEquals(848, ranges.get(0).getMax());
        assertEquals(871, ranges.get(1).getMin());
        assertEquals(949, ranges.get(1).getMax());
    }

}

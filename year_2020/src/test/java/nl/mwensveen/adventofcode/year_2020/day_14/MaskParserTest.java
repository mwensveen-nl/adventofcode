package nl.mwensveen.adventofcode.year_2020.day_14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class MaskParserTest {

    @Test
    public void testParse() throws Exception {
        MaskParser maskParser = new MaskParser();
        Map<Integer, Integer> result = maskParser.parse("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        assertEquals(2, result.size());
        assertEquals(1, result.get(Integer.valueOf(6)));
        assertEquals(0, result.get(Integer.valueOf(1)));
    }

}

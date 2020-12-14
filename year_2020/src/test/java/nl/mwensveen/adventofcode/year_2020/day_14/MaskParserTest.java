package nl.mwensveen.adventofcode.year_2020.day_14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MaskParserTest {

    @Test
    public void testParseVersionOne() throws Exception {
        MaskParser maskParser = new MaskParser();
        Map<Integer, Integer> result = maskParser.parseVersionOne("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        assertEquals(2, result.size());
        assertEquals(1, result.get(Integer.valueOf(6)));
        assertEquals(0, result.get(Integer.valueOf(1)));
    }

    @Test
    public void testParseVersionTwo() throws Exception {
        MaskParser maskParser = new MaskParser();
        List<List<String>> result = maskParser.parseVersionTwo("000000000000000000000000000000X1001X");
        assertEquals(4, result.size());
        result.forEach(System.out::println);
        assertTrue(result.contains(fromString("000000000000000000000000000000010010")));
        assertTrue(result.contains(fromString("000000000000000000000000000000010011")));
        assertTrue(result.contains(fromString("000000000000000000000000000000110010")));
        assertTrue(result.contains(fromString("000000000000000000000000000000110011")));
    }

    private List<String> fromString(String mask) {
        String[] split = mask.split("");
        List<String> orig = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            orig.add(s);
        }
        return orig;
    }

}

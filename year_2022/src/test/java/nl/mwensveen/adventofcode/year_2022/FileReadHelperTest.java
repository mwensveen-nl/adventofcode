package nl.mwensveen.adventofcode.year_2022;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReadHelperTest {

    @Test
    public void testReadLinesAsIntegers() throws Exception {
        List<Integer> integers = FileReadHelper.readLinesAsIntegers("test_01");
        assertEquals(6, integers.size());
        assertEquals(1721, integers.get(0).intValue());
        assertEquals(1456, integers.get(5).intValue());
    }

    @Test
    public void testReadLineAsStrings() {
        String s = FileReadHelper.readLineAsString("test_01");
        assertEquals("1721", s);
    }

}

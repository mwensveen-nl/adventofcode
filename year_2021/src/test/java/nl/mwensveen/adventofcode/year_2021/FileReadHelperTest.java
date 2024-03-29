package nl.mwensveen.adventofcode.year_2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class FileReadHelperTest {

    @Test
    public void testReadLinesAsIntegers() throws Exception {
        List<Integer> integers = FileReadHelper.readLinesAsIntegers("test_01");
        assertEquals(6, integers.size());
        assertEquals(1721, integers.get(0).intValue());
        assertEquals(1456, integers.get(5).intValue());
    }

}

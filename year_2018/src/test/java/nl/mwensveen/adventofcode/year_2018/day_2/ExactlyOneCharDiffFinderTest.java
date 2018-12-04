package nl.mwensveen.adventofcode.year_2018.day_2;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ExactlyOneCharDiffFinderTest {

    @Test
    public void testFinder() {
        List<String> input = Arrays.asList("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz");
        ExactlyOneCharDiffFinder finder = new ExactlyOneCharDiffFinder(input);
        Assert.assertEquals("fgij", finder.find());
    }
}

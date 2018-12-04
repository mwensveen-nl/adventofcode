package nl.mwensveen.adventofcode.year_2018.day_2;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ChecksumCalculatorTest {

    @Test
    public void testExample() {
        List<String> input = Arrays.asList("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab");
        ChecksumCalculator calculator = new ChecksumCalculator(input);
        Assert.assertEquals(12, calculator.calculate());
    }
}

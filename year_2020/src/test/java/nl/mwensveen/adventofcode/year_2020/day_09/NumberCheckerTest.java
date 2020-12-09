package nl.mwensveen.adventofcode.year_2020.day_09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NumberCheckerTest {

    @Test
    public void testCheckValidNumbers() throws Exception {
        List<Long> input =
                Arrays.asList(20L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 21L, 22L, 23L, 24L, 25L, 45L, 65L);
        NumberChecker numberChecker = new NumberChecker();
        assertEquals(65L, numberChecker.checkValidNumbers(input, 25));
    }

    @Test
    public void testCheckValidNumberss() throws Exception {
        List<Long> input = Arrays.asList(35L, 20L, 15L, 25L, 47L, 40L, 62L, 55L, 65L, 95L, 102L, 117L, 150L, 182L, 127L, 219L, 299L, 277L, 309L, 576L);
        NumberChecker numberChecker = new NumberChecker();
        assertEquals(127L, numberChecker.checkValidNumbers(input, 5));
    }

    @Test
    public void testFindContiguousSet() throws Exception {
        List<Long> input = Arrays.asList(35L, 20L, 15L, 25L, 47L, 40L, 62L, 55L, 65L, 95L, 102L, 117L, 150L, 182L, 127L, 219L, 299L, 277L, 309L, 576L);
        NumberChecker numberChecker = new NumberChecker();
        assertEquals(62L, numberChecker.findContiguousSet(input, 127));
    }

}

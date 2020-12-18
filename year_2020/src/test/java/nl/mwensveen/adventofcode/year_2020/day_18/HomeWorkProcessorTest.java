package nl.mwensveen.adventofcode.year_2020.day_18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class HomeWorkProcessorTest {

    @Test
    public void testProcessHomework() throws Exception {
        List<String> input = Arrays.asList("2 * 3 + (4 * 5)", "5 + (8 * 3 + 9 + 3 * 4 * 3)", "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))");
        HomeWorkProcessor homeWorkProcessor = new HomeWorkProcessor();
        long result = homeWorkProcessor.processHomework(input);
        assertEquals(26L + 437L + 12240L, result);
    }

    @Test
    public void testProcessHomeworkAdvanced() throws Exception {
        List<String> input = Arrays.asList("1 + (2 * 3) + (4 * (5 + 6))", "2 * 3 + (4 * 5)", "5 + (8 * 3 + 9 + 3 * 4 * 3)");
        HomeWorkProcessor homeWorkProcessor = new HomeWorkProcessor();
        long result = homeWorkProcessor.processHomeworkAdvanced(input);
        assertEquals(51L + 46L + 1445L, result);
    }

}

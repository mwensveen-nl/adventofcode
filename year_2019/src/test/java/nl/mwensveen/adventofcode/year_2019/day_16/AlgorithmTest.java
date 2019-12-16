package nl.mwensveen.adventofcode.year_2019.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AlgorithmTest {

    @Test
    public void testApplyAlgorithm() throws Exception {
        List<Integer> pattern = Arrays.asList(0, 1, 0, -1);
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Algorithm algorithm = new Algorithm();

        // phase 1
        List<Integer> output = algorithm.applyAlgorithm(input, pattern);
        List<Integer> expected = Arrays.asList(4, 8, 2, 2, 6, 1, 5, 8);
        assertEquals(expected, output);

        // phase 2
        output = algorithm.applyAlgorithm(output, pattern);
        expected = Arrays.asList(3, 4, 0, 4, 0, 4, 3, 8);
        assertEquals(expected, output);

        // phase 3
        output = algorithm.applyAlgorithm(output, pattern);
        expected = Arrays.asList(0, 3, 4, 1, 5, 5, 1, 8);
        assertEquals(expected, output);

        // phase 4
        output = algorithm.applyAlgorithm(output, pattern);
        expected = Arrays.asList(0, 1, 0, 2, 9, 4, 9, 8);
        assertEquals(expected, output);
    }

}

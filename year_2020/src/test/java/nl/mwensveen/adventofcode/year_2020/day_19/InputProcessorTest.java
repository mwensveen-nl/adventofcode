package nl.mwensveen.adventofcode.year_2020.day_19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputProcessorTest {

    @Test
    public void testProcessRules() throws Exception {
        InputProcessor inputProcessor = new InputProcessor();
        Collection<String> process =
                inputProcessor.processRules(Arrays.asList("0: 4 1 5", "1: 2 3 | 3 2", "2: 4 4 | 5 5", "3: 4 5 | 5 4", "4: \"a\"", "5: \"b\"", "", "ababbb"));
        assertEquals(8, process.size());
        assertTrue(process.contains("aaaabb"));
        assertTrue(process.contains("aaabab"));
        assertTrue(process.contains("abbabb"));
        assertTrue(process.contains("abbbab"));
        assertTrue(process.contains("aabaab"));
        assertTrue(process.contains("aabbbb"));
        assertTrue(process.contains("abaaab"));
        assertTrue(process.contains("ababbb"));
    }

    @Test
    public void testProcessMessages() throws Exception {
        InputProcessor inputProcessor = new InputProcessor();
        List<String> input = Arrays.asList("", "ababbb", "bababa", "abbbab", "aaabbb", "aaaabbb");
        Collection<String> result = inputProcessor.processMessages(input);
        assertEquals(5, result.size());
    }

}

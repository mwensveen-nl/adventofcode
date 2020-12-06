package nl.mwensveen.adventofcode.year_2020.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AnswerProcessorTest {

    @Test
    public void testTotalAnyone() throws Exception {
        AnswerProcessor answerProcessor = new AnswerProcessor();
        List<List<String>> input = Arrays.asList(Arrays.asList("abc"),
                Arrays.asList("a", "b", "c"),
                Arrays.asList("ab", "ac"),
                Arrays.asList("a", "a", "a", "a"),
                Arrays.asList("b"));
        assertEquals(11, answerProcessor.totalAnyone(input));
    }

    @Test
    public void testGroupAnswers() throws Exception {
        List<String> input = Arrays.asList("abc",
                "",
                "a",
                "b",
                "c",
                "",
                "ab",
                "ac",
                "",
                "a",
                "a",
                "a",
                "a",
                "",
                "b");

        AnswerProcessor answerProcessor = new AnswerProcessor();
        List<List<String>> answers = answerProcessor.groupAnswers(input);
        assertEquals(5, answers.size());
        assertEquals(1, answers.get(0).size());
        assertEquals(3, answers.get(1).size());
        assertEquals(2, answers.get(2).size());
        assertEquals(4, answers.get(3).size());
        assertEquals(1, answers.get(4).size());
    }

    @Test
    public void testTotalEveryone() throws Exception {
        AnswerProcessor answerProcessor = new AnswerProcessor();
        List<List<String>> input = Arrays.asList(Arrays.asList("abc"),
                Arrays.asList("a", "b", "c"),
                Arrays.asList("ab", "ac"),
                Arrays.asList("a", "a", "a", "a"),
                Arrays.asList("b"));
        assertEquals(6, answerProcessor.totalEveryone(input));
    }

}

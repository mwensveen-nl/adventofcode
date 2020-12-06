package nl.mwensveen.adventofcode.year_2020.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class AnswerCalculatorTest {

    private AnswerCalculator answerProcessor = new AnswerCalculator();

    @Test
    public void testnumberOfAnyoneAnswers() throws Exception {
        assertEquals(3, answerProcessor.numberOfAnyoneAnswers(Arrays.asList("abc")));
        assertEquals(3, answerProcessor.numberOfAnyoneAnswers(Arrays.asList("a", "b", "c")));
        assertEquals(3, answerProcessor.numberOfAnyoneAnswers(Arrays.asList("ab", "ac")));
        assertEquals(1, answerProcessor.numberOfAnyoneAnswers(Arrays.asList("a", "a", "a", "a")));
        assertEquals(1, answerProcessor.numberOfAnyoneAnswers(Arrays.asList("b")));
    }

    @Test
    public void testNumberOfEveryoneAnswers() throws Exception {
        assertEquals(3, answerProcessor.numberOfEveryoneAnswers(Arrays.asList("abc")));
        assertEquals(0, answerProcessor.numberOfEveryoneAnswers(Arrays.asList("a", "b", "c")));
        assertEquals(1, answerProcessor.numberOfEveryoneAnswers(Arrays.asList("ab", "ac")));
        assertEquals(1, answerProcessor.numberOfEveryoneAnswers(Arrays.asList("a", "a", "a", "a")));
        assertEquals(1, answerProcessor.numberOfEveryoneAnswers(Arrays.asList("b")));
    }

}

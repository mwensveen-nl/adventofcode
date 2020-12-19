package nl.mwensveen.adventofcode.year_2020.day_19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Test;

public class RuleValidatorTest {

    @Test
    public void testValidate() throws Exception {
        InputProcessor inputProcessor = new InputProcessor();
        Collection<String> rules =
                inputProcessor.processRules(Arrays.asList("0: 4 1 5", "1: 2 3 | 3 2", "2: 4 4 | 5 5", "3: 4 5 | 5 4", "4: \"a\"", "5: \"b\"", "", "ababbb",
                        "bababa", "abbbab", "aaabbb", "aaaabbb"));
        Collection<String> messages =
                inputProcessor.processMessages(Arrays.asList("0: 4 1 5", "1: 2 3 | 3 2", "2: 4 4 | 5 5", "3: 4 5 | 5 4", "4: \"a\"", "5: \"b\"", "", "ababbb",
                        "bababa", "abbbab", "aaabbb", "aaaabbb"));
        System.out.println(rules);
        System.out.println(messages);
        RuleValidator validator = new RuleValidator();
        long count = validator.validate(rules, messages);
        assertEquals(2, count);
    }

}

package nl.mwensveen.adventofcode.year_2020.day_19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RuleValidatorTest {

    private static final List<String> LONG_INPUT = Arrays.asList("42: 9 14 | 10 1",
            "9: 14 27 | 1 26",
            "10: 23 14 | 28 1",
            "1: \"a\"",
            "11: 42 31",
            "5: 1 14 | 15 1",
            "19: 14 1 | 14 14",
            "12: 24 14 | 19 1",
            "16: 15 1 | 14 14",
            "31: 14 17 | 1 13",
            "6: 14 14 | 1 14",
            "2: 1 24 | 14 4",
            "0: 8 11",
            "13: 14 3 | 1 12",
            "15: 1 | 14",
            "17: 14 2 | 1 7",
            "23: 25 1 | 22 14",
            "28: 16 1",
            "4: 1 1",
            "20: 14 14 | 1 15",
            "3: 5 14 | 16 1",
            "27: 1 6 | 14 18",
            "14: \"b\"",
            "21: 14 1 | 1 14",
            "25: 1 1 | 1 14",
            "22: 14 14",
            "8: 42",
            "26: 14 22 | 1 20",
            "18: 15 15",
            "7: 14 5 | 1 21",
            "24: 14 1",
            "",
            "abbbbbabbbaaaababbaabbbbabababbbabbbbbbabaaaa",
            "bbabbbbaabaabba",
            "babbbbaabbbbbabbbbbbaabaaabaaa",
            "aaabbbbbbaaaabaababaabababbabaaabbababababaaa",
            "bbbbbbbaaaabbbbaaabbabaaa",
            "bbbababbbbaaaaaaaabbababaaababaabab",
            "ababaaaaaabaaab",
            "ababaaaaabbbaba",
            "baabbaaaabbaaaababbaababb",
            "abbbbabbbbaaaababbbbbbaaaababb",
            "aaaaabbaabaaaaababaa",
            "aaaabbaaaabbaaa",
            "aaaabbaabbaaaaaaabbbabbbaaabbaabaaa",
            "babaaabbbaaabaababbaabababaaab",
            "aabbbbbaabbbaaaaaabbbbbababaaaaabbaaabba");

    @Test
    public void testValidate() throws Exception {
        InputProcessor inputProcessor = new InputProcessor();
        Multimap<Integer, String> rules =
                inputProcessor.processRules(Arrays.asList("0: 4 1 5", "1: 2 3 | 3 2", "2: 4 4 | 5 5", "3: 4 5 | 5 4", "4: \"a\"", "5: \"b\"", "", "ababbb",
                        "bababa", "abbbab", "aaabbb", "aaaabbb"));
        Collection<String> messages =
                inputProcessor.processMessages(Arrays.asList("0: 4 1 5", "1: 2 3 | 3 2", "2: 4 4 | 5 5", "3: 4 5 | 5 4", "4: \"a\"", "5: \"b\"", "", "ababbb",
                        "bababa", "abbbab", "aaabbb", "aaaabbb"));
        RuleValidator validator = new RuleValidator();
        long count = validator.validate(rules.get(Integer.valueOf(0)), messages);
        assertEquals(2, count);
    }

    @Test
    public void testValidate2() throws Exception {
        InputProcessor inputProcessor = new InputProcessor();
        Multimap<Integer, String> rules = inputProcessor.processRules(LONG_INPUT);
        Collection<String> messages = inputProcessor.processMessages(LONG_INPUT);
        RuleValidator validator = new RuleValidator();
        long count = validator.validate(rules.get(Integer.valueOf(0)), messages);
        assertEquals(3, count);
    }

    @Test
    public void testValidateInfinite2() throws Exception {
        InputProcessor inputProcessor = new InputProcessor();
        Multimap<Integer, String> rules = inputProcessor.processRules(LONG_INPUT);
        System.out.println(rules.get(42));
        System.out.println(rules.get(31));
    }

    @Test
    public void testValidateInfinite() throws Exception {
        InputProcessor inputProcessor = new InputProcessor();
        Multimap<Integer, String> rules = inputProcessor.processRules(LONG_INPUT);
        Collection<String> messages = inputProcessor.processMessages(LONG_INPUT);
        RuleValidator validator = new RuleValidator();
        assertEquals(12, validator.validateInfinite(rules, messages));
    }

}

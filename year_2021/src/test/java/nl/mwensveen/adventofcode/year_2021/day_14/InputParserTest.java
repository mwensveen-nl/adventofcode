package nl.mwensveen.adventofcode.year_2021.day_14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    public void testParseInput() {
        List<String> input = Arrays.asList("NNCB",
                "",
                "CH -> B",
                "HH -> N",
                "CB -> H",
                "NH -> C",
                "HB -> C",
                "HC -> B",
                "HN -> C",
                "NN -> C",
                "BH -> H",
                "NC -> B",
                "NB -> B",
                "BN -> B",
                "BB -> N",
                "BC -> B",
                "CC -> N",
                "CN -> C");
        InputParser inputParser = new InputParser();
        Pair<String, List<InsertionRule>> result = inputParser.parseInput(input);
        assertEquals("NNCB", result.getValue0());
        List<InsertionRule> rules = result.getValue1();
        assertEquals(16, rules.size());
        InsertionRule rule = rules.get(0);
        assertEquals("CH", rule.getInsertBetween());
        assertEquals(2, rule.getBecomes().size());
        assertTrue(rule.getBecomes().contains("CB"));
        assertTrue(rule.getBecomes().contains("BH"));
    }

}

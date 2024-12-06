package nl.mwensveen.adventofcode.year_2024.day_05;

import com.google.common.collect.Multimap;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrinterParserTest {
    private String input = """
            47|53
            97|13
            97|61
            97|47
            75|29
            61|13
            75|53
            29|13
            97|29
            53|29
            61|53
            97|53
            61|29
            47|13
            75|47
            97|75
            47|61
            75|61
            47|29
            75|13
            53|13

            75,47,61,53,29
            97,61,53,29,13
            75,29,13
            75,97,47,61,53
            61,13,29
            97,13,75,29,47
                    """;

    @Test
    public void testParseRules() {
        PrinterParser parser = new PrinterParser();
        Multimap<Integer, Integer> rules = parser.parseRules(input.lines().toList());
        assertEquals(21, rules.size());
        assertTrue(rules.get(Integer.valueOf(29)).contains(Integer.valueOf(13)));

        assertTrue(rules.get(47).contains(13));
        assertTrue(rules.get(47).contains(29));
        assertTrue(rules.get(47).contains(53));
        assertTrue(rules.get(47).contains(61));

        assertTrue(rules.get(53).contains(13));
        assertTrue(rules.get(53).contains(29));
    }

    @Test
    public void testParseUpdates() {
        PrinterParser parser = new PrinterParser();
        List<List<Integer>> updates = parser.parseUpdates(input.lines().toList());
        assertEquals(6, updates.size());
        assertEquals(updates.get(0).get(0), 75);
        assertEquals(updates.get(0).get(1), 47);
        assertEquals(updates.get(0).get(2), 61);
        assertEquals(updates.get(0).get(3), 53);
        assertEquals(updates.get(0).get(4), 29);
    }

}

package nl.mwensveen.adventofcode.year_2024.day_05;

import com.google.common.collect.Multimap;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdatePrinterTest {
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
    public void testCheckUpdates() {
        PrinterParser parser = new PrinterParser();
        Multimap<Integer, Integer> rules = parser.parseRules(input.lines().toList());
        List<List<Integer>> updates = parser.parseUpdates(input.lines().toList());

        UpdatePrinter checker = new UpdatePrinter();
        long result = checker.checkUpdates(rules, updates);
        assertEquals(143, result);
    }

    @Test
    public void testFixUpdates() {
        PrinterParser parser = new PrinterParser();
        Multimap<Integer, Integer> rules = parser.parseRules(input.lines().toList());
        List<List<Integer>> updates = parser.parseUpdates(input.lines().toList());

        UpdatePrinter checker = new UpdatePrinter();
        long result = checker.fixUpdates(rules, updates);
        assertEquals(123, result);
    }

}

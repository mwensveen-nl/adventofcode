package nl.mwensveen.adventofcode.year_2020.day_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BagRuleParserTest {
    private BagRuleParser parser = new BagRuleParser();

    @Test
    public void testParse() throws Exception {
        BagRule bagRule = parser.parse("light red bags contain 1 bright white bag, 2 muted yellow bags.");
        assertEquals("light red", bagRule.getColor());
        List<BagContents> contains = bagRule.getContains();
        assertEquals(2, contains.size());
        assertContents(contains.get(0), 1, "bright white");
        assertContents(contains.get(1), 2, "muted yellow");
    }

    @Test
    public void testParseNoContains() throws Exception {
        BagRule bagRule = parser.parse("faded blue bags contain no other bags.");
        assertEquals("faded blue", bagRule.getColor());
        List<BagContents> contains = bagRule.getContains();
        assertEquals(0, contains.size());
    }

    private void assertContents(BagContents bagContents, int number, String color) {
        assertEquals(number, bagContents.getNumber());
        assertEquals(color, bagContents.getColor());
    }

    @Test
    public void testParseBagRules() throws Exception {
        List<String> input = Arrays.asList("light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.", "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.", "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.", "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.", "dotted black bags contain no other bags.");
        Map<String, BagRule> parsedMap = parser.parseBagRules(input);
        Collection<BagRule> parseList = parsedMap.values();
        assertEquals(9, parseList.size());
        parsedMap.forEach((k, v) -> assertEquals(k, v.getColor()));
    }

}

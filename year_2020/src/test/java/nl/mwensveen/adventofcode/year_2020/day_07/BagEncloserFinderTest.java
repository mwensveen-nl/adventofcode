package nl.mwensveen.adventofcode.year_2020.day_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BagEncloserFinderTest {

    @Test
    public void testFindNumberOfEncloserBags() throws Exception {
        List<String> input = Arrays.asList("light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.", "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.", "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.", "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.", "dotted black bags contain no other bags.");
        BagRuleParser parser = new BagRuleParser();
        Map<String, BagRule> bagRules = parser.parseBagRules(input);
        BagEncloserFinder bagEncloserFinder = new BagEncloserFinder();
        long n = bagEncloserFinder.findNumberOfEncloserBags(bagRules.values());
        assertEquals(4L, n);
    }

    @Test
    public void testFindNumberOfBagsInside() throws Exception {
        List<String> input = Arrays.asList("light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.", "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.", "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.", "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.", "dotted black bags contain no other bags.");
        BagRuleParser parser = new BagRuleParser();
        Map<String, BagRule> bagRules = parser.parseBagRules(input);
        BagEncloserFinder bagEncloserFinder = new BagEncloserFinder();
        long inside = bagEncloserFinder.findNumberOfBagsInside(bagRules);
        assertEquals(32, inside);
    }

    @Test
    public void testFindNumberOfBagsInside2() throws Exception {
        List<String> input = Arrays.asList("shiny gold bags contain 2 dark red bags.", "dark red bags contain 2 dark orange bags.",
                "dark orange bags contain 2 dark yellow bags.", "dark yellow bags contain 2 dark green bags.", "dark green bags contain 2 dark blue bags.",
                "dark blue bags contain 2 dark violet bags.", "dark violet bags contain no other bags.");
        BagRuleParser parser = new BagRuleParser();
        Map<String, BagRule> bagRules = parser.parseBagRules(input);
        BagEncloserFinder bagEncloserFinder = new BagEncloserFinder();
        long inside = bagEncloserFinder.findNumberOfBagsInside(bagRules);
        assertEquals(126, inside);
    }

}

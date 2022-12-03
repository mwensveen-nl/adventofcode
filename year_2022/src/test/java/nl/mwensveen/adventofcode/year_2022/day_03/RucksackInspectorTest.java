package nl.mwensveen.adventofcode.year_2022.day_03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RucksackInspectorTest {

    private static String input = """
            vJrwpWtwJgWrhcsFMMfFFhFp
            jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
            PmmdzqPrVvPwwTWBwg
            wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
            ttgJtRGJQctTZtZT
            CrZsJsPPZsGzwwsLwLmpwMDw
            """;
    private RucksackInspector rucksackInspector = new RucksackInspector();

    @Test
    public void testInspectRucksackCompartments() {
        assertEquals(16, rucksackInspector.inspectRucksackCompartments("vJrwpWtwJgWrhcsFMMfFFhFp"));
        assertEquals(38, rucksackInspector.inspectRucksackCompartments("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"));
        assertEquals(42, rucksackInspector.inspectRucksackCompartments("PmmdzqPrVvPwwTWBwg"));
        assertEquals(22, rucksackInspector.inspectRucksackCompartments("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"));
        assertEquals(20, rucksackInspector.inspectRucksackCompartments("ttgJtRGJQctTZtZT"));
        assertEquals(19, rucksackInspector.inspectRucksackCompartments("CrZsJsPPZsGzwwsLwLmpwMDw"));
    }

    @Test
    public void testInspectSingleRucksacks() {
        assertEquals(157, rucksackInspector.inspectSingleRucksacks(input.lines().toList()));
    }

    @Test
    public void testInspectRucksackTriple() {
        assertEquals(18, rucksackInspector.inspectRucksackTriple("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg"));
        assertEquals(52, rucksackInspector.inspectRucksackTriple("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw"));
    }

    @Test
    public void testInspectTripleRucksacks() {
        int prio = rucksackInspector.inspectTripleRucksacks(input.lines().toList());
        assertEquals(70, prio);
    }

}

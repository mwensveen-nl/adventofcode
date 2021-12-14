package nl.mwensveen.adventofcode.year_2021.day_14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

public class PolymerRulesProcessorTest {

    @Test
    public void testProcess() {
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
        Pair<String, List<InsertionRule>> parsedInput = inputParser.parseInput(input);

        PolymerRulesProcessor polymerRulesProcessor = new PolymerRulesProcessor();
        long result = polymerRulesProcessor.process(parsedInput, 10);
        assertEquals(1588, result);
    }

}

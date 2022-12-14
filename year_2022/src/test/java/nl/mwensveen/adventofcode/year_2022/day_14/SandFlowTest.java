package nl.mwensveen.adventofcode.year_2022.day_14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SandFlowTest {
    private String input = """
            498,4 -> 498,6 -> 496,6
            503,4 -> 502,4 -> 502,9 -> 494,9
                    """;

    @Test
    public void testFlowSand() {
        RockParser parser = new RockParser();
        Cave cave = parser.parse(input.lines().toList());
        SandFlow sandFlow = new SandFlow();
        int sands = sandFlow.flowSand(cave);
        assertEquals(24, sands);
    }

}

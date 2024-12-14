package nl.mwensveen.adventofcode.year_2024.day_12;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FenceCalculatorTest {
    private static final String input = """
            RRRRIICCFF
            RRRRIICCCF
            VVRRRCCFFF
            VVRCCCJFFF
            VVVVCJJCFE
            VVIVCCJJEE
            VVIIICJJEE
            MIIIIIJJEE
            MIIISIJEEE
            MMMISSJEEE
                    """;

    @Test
    public void testCalculate() {
        Table<Long, Long, String> table = new GardenParser().parse(input.lines().toList());
        long result = new FenceCalculator().calculate(table);
        assertEquals(1930, result);
    }

}

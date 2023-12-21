package nl.mwensveen.adventofcode.year_2023.day_16;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnergyMaximizerTest {
    private String input = """
            .|...\\....
            |.-.\\.....
            .....|-...
            ........|.
            ..........
            .........\\
            ..../.\\\\..
            .-.-/..|..
            .|....-|.\\
            ..//.|....
                    """;

    @Test
    public void testMaximize() {
        ContraptionParser contraptionParser = new ContraptionParser();
        Table<Integer, Integer, Cell> table = contraptionParser.parse(input.lines().toList());
        EnergyMaximizer energyMaximizer = new EnergyMaximizer();
        long result = energyMaximizer.maximize(table);
        assertEquals(51, result);
    }

}

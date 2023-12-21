package nl.mwensveen.adventofcode.year_2023.day_16;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContraptionBeamerTest {
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
    public void testBeamTopLeft() {
        ContraptionParser contraptionParser = new ContraptionParser();
        Table<Integer, Integer, Cell> table = contraptionParser.parse(input.lines().toList());
        ContraptionBeamer contraptionBeamer = new ContraptionBeamer();
        long result = contraptionBeamer.beamTopLeft(table);
        assertEquals(46, result);
    }

}

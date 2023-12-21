package nl.mwensveen.adventofcode.year_2023.day_16;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContraptionParserTest {
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
    public void testParse() {
        ContraptionParser contraptionParser = new ContraptionParser();
        Table<Integer, Integer, Cell> table = contraptionParser.parse(input.lines().toList());
        assertEquals(Item.EMPTY_SPACE, table.get(0, 0).item());
        assertEquals(Item.SPLITTER_VERTICAL, table.get(0, 1).item());
        assertEquals(Item.MIRROR_BACKSLASH, table.get(8, 9).item());
    }

}

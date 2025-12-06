package nl.mwensveen.adventofcode.year_2025.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

class IngredientListParserTest {
    private String input = """
            3-5
            10-14
            16-20
            12-18

            1
            5
            8
            11
            17
            32
                        """;

    @Test
    public void parse() {
        Pair<List<IngredientRange>, List<Long>> pair = new IngredientListParser().parse(input.lines().toList());
        List<IngredientRange> ranges = pair.getValue0();
        List<Long> ingredients = pair.getValue1();

        assertEquals(4, ranges.size());
        assertEquals(3, ranges.getFirst().start());
        assertEquals(5, ranges.getFirst().end());
        assertEquals(12, ranges.getLast().start());
        assertEquals(18, ranges.getLast().end());

        assertEquals(6, ingredients.size());
        assertEquals(1, ingredients.getFirst());
        assertEquals(32, ingredients.getLast());

    }

}

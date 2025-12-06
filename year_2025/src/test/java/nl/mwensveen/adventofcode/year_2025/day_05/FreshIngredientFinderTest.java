package nl.mwensveen.adventofcode.year_2025.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

class FreshIngredientFinderTest {
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
    public void findFresh() {
        Pair<List<IngredientRange>, List<Long>> pair = new IngredientListParser().parse(input.lines().toList());

        long fresh = new FreshIngredientFinder().findFresh(pair);
        assertEquals(3, fresh);
    }

}

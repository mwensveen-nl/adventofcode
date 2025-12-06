package nl.mwensveen.adventofcode.year_2025.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
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
    private String input2 = """
            5-8
            3-6
            7-10
            6-8
            3-10

            1
                        """;
    private String input3 = """
            5-8
            3-6

            1
                        """;
    private String input4 = """
            5-8
            7-10

            1
                        """;
    private String input5 = """
            5-8
            6-8

            1
                        """;
    private String input6 = """
            5-8
            3-10

            1
                        """;

    @Test
    public void findFresh() {
        Pair<List<IngredientRange>, List<Long>> pair = new IngredientListParser().parse(input.lines().toList());

        long fresh = new FreshIngredientFinder().findFresh(pair);
        assertEquals(3, fresh);
    }

    @Test
    public void findFeshIdInRanges() {
        Pair<List<IngredientRange>, List<Long>> pair = new IngredientListParser().parse(input.lines().toList());
        BigInteger fresh = new FreshIngredientFinder().findFeshIdInRanges(pair.getValue0());
        assertEquals(14, fresh.longValue());
    }

    @Test
    public void findFeshIdInRanges2() {
        Pair<List<IngredientRange>, List<Long>> pair = new IngredientListParser().parse(input2.lines().toList());
        BigInteger fresh = new FreshIngredientFinder().findFeshIdInRanges(pair.getValue0());
        assertEquals(8, fresh.longValue());
    }

    @Test
    public void findFeshIdInRanges3() {
        Pair<List<IngredientRange>, List<Long>> pair = new IngredientListParser().parse(input3.lines().toList());
        BigInteger fresh = new FreshIngredientFinder().findFeshIdInRanges(pair.getValue0());
        assertEquals(6, fresh.longValue());
    }

    @Test
    public void findFeshIdInRanges4() {
        Pair<List<IngredientRange>, List<Long>> pair = new IngredientListParser().parse(input4.lines().toList());
        BigInteger fresh = new FreshIngredientFinder().findFeshIdInRanges(pair.getValue0());
        assertEquals(6, fresh.longValue());
    }

    @Test
    public void findFeshIdInRanges5() {
        Pair<List<IngredientRange>, List<Long>> pair = new IngredientListParser().parse(input5.lines().toList());
        BigInteger fresh = new FreshIngredientFinder().findFeshIdInRanges(pair.getValue0());
        assertEquals(4, fresh.longValue());
    }

    @Test
    public void findFeshIdInRanges6() {
        Pair<List<IngredientRange>, List<Long>> pair = new IngredientListParser().parse(input6.lines().toList());
        BigInteger fresh = new FreshIngredientFinder().findFeshIdInRanges(pair.getValue0());
        assertEquals(8, fresh.longValue());
    }

}

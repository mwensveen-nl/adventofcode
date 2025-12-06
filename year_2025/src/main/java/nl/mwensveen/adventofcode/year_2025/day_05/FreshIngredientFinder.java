package nl.mwensveen.adventofcode.year_2025.day_05;

import java.util.List;
import org.javatuples.Pair;

public class FreshIngredientFinder {

    public long findFresh(Pair<List<IngredientRange>, List<Long>> input) {
        List<IngredientRange> ranges = input.getValue0();
        List<Long> ingredients = input.getValue1();

        return ingredients.stream().filter(in -> inRange(in, ranges)).count();
    }

    private boolean inRange(Long in, List<IngredientRange> ranges) {
        return ranges.stream().anyMatch(r -> r.inRange(in));
    }
}

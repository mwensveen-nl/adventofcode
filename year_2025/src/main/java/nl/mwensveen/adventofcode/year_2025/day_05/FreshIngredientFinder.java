package nl.mwensveen.adventofcode.year_2025.day_05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;

public class FreshIngredientFinder {

    public long findFresh(Pair<List<IngredientRange>, List<Long>> input) {
        List<IngredientRange> ranges = input.getValue0();
        List<Long> ingredients = input.getValue1();

        return ingredients.stream().filter(in -> inRange(in, ranges)).count();
    }

    public BigInteger findFeshIdInRanges(List<IngredientRange> inputRanges) {
        List<IngredientRange> distinctRanges = distinctRanges(inputRanges);

        return distinctRanges.stream()
                .map(IngredientRange::count)
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private List<IngredientRange> distinctRanges(List<IngredientRange> inputRanges) {
        List<IngredientRange> ranges = inputRanges;
        List<IngredientRange> newRanges = new ArrayList<>();

        for (int i = 0; i < ranges.size(); i++) {
            IngredientRange range = ranges.get(i);
            for (int j = 0; j < newRanges.size(); j++) {
                IngredientRange ingredientRange = newRanges.get(j);
                if (ingredientRange == null) {
                    continue;
                }

                if (range.start() >= ingredientRange.start() && range.end() <= ingredientRange.end()) {
                    range = null;
                    break;
                } else if (ingredientRange.start() >= range.start() && ingredientRange.end() <= range.end()) {
                    newRanges.set(j, null);
                } else if (range.end() >= ingredientRange.start() && range.end() <= ingredientRange.end()) {
                    range = new IngredientRange(range.start(), ingredientRange.start() - 1);
                } else if (range.start() >= ingredientRange.start() && range.start() <= ingredientRange.end()) {
                    range = new IngredientRange(ingredientRange.end() + 1, range.end());
                }
            }
            newRanges.add(range);
        }
        return newRanges.stream().filter(r -> r != null).toList();
    }

    private boolean inRange(Long in, List<IngredientRange> ranges) {
        return ranges.stream().anyMatch(r -> r.inRange(in));
    }
}

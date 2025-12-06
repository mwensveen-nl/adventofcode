package nl.mwensveen.adventofcode.year_2025.day_05;

import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;

public class IngredientListParser {

    public Pair<List<IngredientRange>, List<Long>> parse(List<String> input) {
        List<IngredientRange> ranges = new ArrayList<>();
        List<Long> ingredients = new ArrayList<>();

        boolean rangeProcess = true;
        for (String string : input) {
            if (string == null || string.isEmpty()) {
                rangeProcess = false;
            } else if (rangeProcess) {
                ranges.add(new IngredientRange(string));
            } else {
                ingredients.add(Long.valueOf(string));
            }
        }
        return new Pair<>(ranges, ingredients);
    }
}

package nl.mwensveen.adventofcode.year_2020.day_21;

import java.util.List;

public class IngredientsProcessor {

    public long process(List<String> all, List<String> found) {
        return all.stream().filter(s -> !found.contains(s)).count();
    }
}

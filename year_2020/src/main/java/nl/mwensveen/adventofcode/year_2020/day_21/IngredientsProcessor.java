package nl.mwensveen.adventofcode.year_2020.day_21;

import java.util.List;
import java.util.stream.Collectors;

public class IngredientsProcessor {

    public long findSaveIngredients(List<String> all, List<String> found) {
        return all.stream().filter(s -> !found.contains(s)).count();
    }

    public String listAllergIngredenties(List<Allergen> allergens) {
        return allergens.stream().distinct().sorted((a1, a2) -> a1.getName().compareTo(a2.getName())).map(a -> a.getPossibleCode().get(0))
                .collect(Collectors.joining(","));
    }
}

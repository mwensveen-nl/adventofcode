package nl.mwensveen.adventofcode.year_2020.day_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllergenParser {
    private static final String CONTAINS = "(contains ";
    public static int CONTAINS_LENGTH = CONTAINS.length();

    public List<Allergen> parse(String input) {
        // mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
        int index = input.indexOf(CONTAINS);
        String allergensString = input.substring(index + CONTAINS_LENGTH, input.length() - 1);
        String ingredientsString = input.substring(0, index).trim();

        String[] ingredients = ingredientsString.split(" ");
        String[] allergens = allergensString.split(",");

        List<String> ingredientsList = Arrays.asList(ingredients);
        List<Allergen> allergensList = new ArrayList<>();
        for (int i = 0; i < allergens.length; i++) {
            allergensList.add(Allergen.builder().withName(allergens[i].trim()).withPossibleCode(ingredientsList).build());
        }

        return allergensList;
    }
}

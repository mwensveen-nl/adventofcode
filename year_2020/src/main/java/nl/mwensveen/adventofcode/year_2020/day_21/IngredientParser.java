package nl.mwensveen.adventofcode.year_2020.day_21;

import java.util.Arrays;
import java.util.List;

public class IngredientParser {
    private static final String CONTAINS = "(contains ";
    public static int CONTAINS_LENGTH = CONTAINS.length();

    public List<String> parse(String input) {
        // mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
        int index = input.indexOf(CONTAINS);
        String ingredientsString = input.substring(0, index).trim();

        String[] ingredients = ingredientsString.split(" ");

        List<String> ingredientsList = Arrays.asList(ingredients);

        return ingredientsList;
    }
}

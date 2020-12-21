package nl.mwensveen.adventofcode.year_2020.day_21;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public AllergenInput parse(List<String> input) {
        AllergenParser parser = new AllergenParser();
        List<Allergen> allergens = input.stream().map(parser::parse).flatMap(Collection::stream).collect(Collectors.toList());

        IngredientParser ingredientParser = new IngredientParser();
        List<String> ingredients = input.stream().map(ingredientParser::parse).flatMap(Collection::stream).collect(Collectors.toList());
        return AllergenInput.builder().withAllergens(allergens).withIngredients(ingredients).build();
    }

}

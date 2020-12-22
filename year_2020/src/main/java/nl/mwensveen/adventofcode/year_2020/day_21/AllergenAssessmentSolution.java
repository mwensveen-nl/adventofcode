package nl.mwensveen.adventofcode.year_2020.day_21;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class AllergenAssessmentSolution extends AbstractTimedSolution {

    private AllergenInput input;

    @Override
    protected void init() {
        List<String> inputStrings = FileReadHelper.readLinesAsStrings("Day_21.txt");
        InputParser inputParser = new InputParser();
        input = inputParser.parse(inputStrings);
    }

    @Override
    protected void part1() {
        List<Allergen> allergens = input.getAllergens();
        List<String> ingredients = input.getIngredients();

        AllergenProcessor allergenProcessor = new AllergenProcessor();
        List<String> found = allergenProcessor.findIngredentsOfAllergens(allergens);

        IngredientsProcessor ingredientsProcessor = new IngredientsProcessor();
        long result = ingredientsProcessor.findSaveIngredients(ingredients, found);

        System.out.println("Number ingredients that cannot possibly contain any of the allergens in your list = " + result);
    }

    @Override
    protected void part2() {
        List<Allergen> allergens = input.getAllergens();
        AllergenProcessor allergenProcessor = new AllergenProcessor();
        List<Allergen> found = allergenProcessor.findAllergens(allergens);

        IngredientsProcessor ingredientsProcessor = new IngredientsProcessor();
        String result = ingredientsProcessor.listAllergIngredenties(allergens);

        System.out.println("The canonical dangerous ingredient list = " + result);
    }

    public static void main(String[] args) {
        new AllergenAssessmentSolution().run();
    }

}

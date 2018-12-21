package nl.mwensveen.adventofcode.year_2018.day_14;

public class RecipeSolution {
    public static void main(String[] args) {
        String input = "170641";
        RecipeProduction recipeProduction = new RecipeProduction(input);
        System.out.println("the scores of the ten recipes after " + input + " is " + recipeProduction.producePartOne());
        recipeProduction = new RecipeProduction(input);
        System.out.println("the scores of " + input + " appears after " + recipeProduction.producePartTwo());
    }
}

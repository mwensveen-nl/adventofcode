package nl.mwensveen.adventofcode.year_2018.day_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RecipeProduction {

    private int tries;
    private List<Integer> searchScore = new ArrayList<>();
    private List<Integer> recipes = new ArrayList<>(Arrays.asList(3, 7));
    private StringBuilder recipesString = new StringBuilder().append(3).append(7);
    private int currentOne = 0;
    private int currentTwo = 1;

    public RecipeProduction(String input) {
        this.tries = Integer.valueOf(input);
        IntStream.range(0, input.length()).forEach(i -> searchScore.add(Integer.parseInt(input.substring(i, i + 1))));
        System.out.println(input + " " + searchScore);
    }

    public String producePartOne() {
        while (recipes.size() < tries + 10) {
            int sum = recipes.get(currentOne) + recipes.get(currentTwo);
            int firstNew = sum / 10;
            int secondNew = sum % 10;
            if (firstNew != 0) {
                recipes.add(firstNew);
            }
            recipes.add(secondNew);

            currentOne += recipes.get(currentOne) + 1;
            currentOne = currentOne % recipes.size();

            currentTwo += recipes.get(currentTwo) + 1;
            currentTwo = currentTwo % recipes.size();
        }
        StringBuilder stringBuilder = new StringBuilder(10);
        IntStream.range(tries, tries + 10).forEach(i -> stringBuilder.append(recipes.get(i)));
        return stringBuilder.toString();
    }

    public int producePartTwo() {
        boolean found = false;
        int index = 0;

        while (!found) {
            Integer valueOne = recipes.get(currentOne);
            Integer valueTwo = recipes.get(currentTwo);
            int sum = valueOne + valueTwo;
            int firstNew = sum / 10;
            int secondNew = sum % 10;
            if (firstNew != 0) {
                recipes.add(firstNew);
                index = getIndex(index, firstNew);
            }
            if (index < searchScore.size()) {
                recipes.add(secondNew);
                index = getIndex(index, secondNew);
            }

            if (index == searchScore.size()) {
                found = true;
            }
            currentOne += recipes.get(currentOne) + 1;
            currentOne = currentOne % recipes.size();

            currentTwo += recipes.get(currentTwo) + 1;
            currentTwo = currentTwo % recipes.size();
        }

        return recipes.size() - searchScore.size();
    }

    private int getIndex(int index, int newRecipe) {
        if (searchScore.get(index).equals(newRecipe)) {
            index++;
        } else if (searchScore.get(0).equals(newRecipe)) {
            index = 1;
        } else {
            index = 0;
        }
        return index;
    }
}

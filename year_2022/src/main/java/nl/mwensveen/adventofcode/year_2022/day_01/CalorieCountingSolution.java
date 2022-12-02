package nl.mwensveen.adventofcode.year_2022.day_01;

import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class CalorieCountingSolution extends AbstractTimedSolution {

    private List<String> input;
    CalorieCounter calorieCounter = new CalorieCounter();

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day01.txt");
    }

    @Override
    protected void part1() {
        Long mostCalories = calorieCounter.countMostCalories(input);
        System.out.println("Most calories caried by an elf: " + mostCalories);
    }

    @Override
    protected void part2() {
        Long sumThreeCalories = calorieCounter.countThreeMostCalories(input);
        System.out.println("Sum of top three calories caried by  elf: " + sumThreeCalories);
    }

    public static void main(String[] args) {
        new CalorieCountingSolution().run();

    }

}

package nl.mwensveen.adventofcode.year_2022.day_01;

import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class CalorieCountingSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day01.txt");
    }

    @Override
    protected void part1() {
        CalorieCounter calorieCounter = new CalorieCounter();
        Long mostCalories = calorieCounter.countMostCalories(input);
        System.out.println("Most calories caried by an elf: " + mostCalories);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new CalorieCountingSolution().run();

    }

}

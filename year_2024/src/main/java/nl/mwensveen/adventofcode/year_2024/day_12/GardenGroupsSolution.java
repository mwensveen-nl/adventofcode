package nl.mwensveen.adventofcode.year_2024.day_12;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class GardenGroupsSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = new FileReadHelper().readLinesAsStrings("Day_12.txt");
    }

    @Override
    protected void part1() {
        Table<Long, Long, String> garden = new GardenParser().parse(input);
        long result = new FenceCalculator().calculate(garden);
        System.out.println("The total price of fencing all regions on the map: " + result);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new GardenGroupsSolution().run();
    }

}

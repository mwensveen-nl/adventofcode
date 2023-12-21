package nl.mwensveen.adventofcode.year_2023.day_16;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class TheFloorWillBeLavaSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_16.txt");
    }

    @Override
    protected void part1() {
        Table<Integer, Integer, Cell> contraption = new ContraptionParser().parse(input);
        long result = new ContraptionBeamer().beamTopLeft(contraption);
        System.out.println("Number of tiles that end up being energized: " + result);
    }

    @Override
    protected void part2() {
        Table<Integer, Integer, Cell> contraption = new ContraptionParser().parse(input);
        EnergyMaximizer energyMaximizer = new EnergyMaximizer();
        long result = energyMaximizer.maximize(contraption);
        System.out.println("Maximum number of tiles that can be energized: " + result);
    }

    public static void main(String[] args) {
        new TheFloorWillBeLavaSolution().run();
    }

}

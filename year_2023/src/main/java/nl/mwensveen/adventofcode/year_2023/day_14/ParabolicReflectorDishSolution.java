package nl.mwensveen.adventofcode.year_2023.day_14;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class ParabolicReflectorDishSolution extends AbstractTimedSolution {

    private List<String> input;
    private long result;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_14.txt");
    }

    @Override
    protected void part1() {
        Table<Integer, Integer, Rock> platform = new PlatformParser().parse(input);
        result = new PlatformTilter().tiltNorth(platform);
        System.out.println("The total load on the north support beams: " + result);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new ParabolicReflectorDishSolution().run();
    }

}

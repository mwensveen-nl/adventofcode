package nl.mwensveen.adventofcode.year_2025.day_10;

import java.util.List;
import nl.mwensveen.adventofcode.year_2025.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2025.FileReadHelper;

public class FactorySolution extends AbstractTimedSolution {
    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_10.txt");
    }

    @Override
    protected void part1() {
        MachineParser machineParser = new MachineParser();
        List<Machine> machines = input.stream().map(s -> machineParser.parse(s)).toList();
        int resut = new IndicatorLightConfigurator().configure(machines);
        System.out.println("The fewest button presses required to correctly configure the indicator lights on all of the machines: " + resut);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new FactorySolution().run();
    }
}

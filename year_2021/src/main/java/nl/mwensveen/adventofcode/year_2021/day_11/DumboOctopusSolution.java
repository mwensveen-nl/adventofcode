package nl.mwensveen.adventofcode.year_2021.day_11;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class DumboOctopusSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_11.txt");
    }

    @Override
    protected void part1() {
        OctopusEnergySolver octopusEnergySolver = new OctopusEnergySolver();
        long result = octopusEnergySolver.measureEnergy(input, 100);
        System.out.println("Total flashes after 100 steps: " + result);
    }

    @Override
    protected void part2() {
        OctopusEnergySolver octopusEnergySolver = new OctopusEnergySolver();
        long result = octopusEnergySolver.findAllFlashes(input);
        System.out.println("The first step during which all octopuses flash: " + result);

    }

    public static void main(String[] args) {
        new DumboOctopusSolution().run();
    }

}

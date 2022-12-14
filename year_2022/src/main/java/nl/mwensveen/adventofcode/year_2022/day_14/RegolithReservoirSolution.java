package nl.mwensveen.adventofcode.year_2022.day_14;

import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class RegolithReservoirSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day14.txt");
    }

    @Override
    protected void part1() {
        RockParser rockParser = new RockParser();
        Cave cave = rockParser.parse(input);
        SandFlow sandFlow = new SandFlow();
        int sands = sandFlow.flowSandInfinite(cave);
        System.out.println("Number of units of sand that come to rest before sand starts flowing into the abyss below: " + sands);
    }

    @Override
    protected void part2() {
        RockParser rockParser = new RockParser();
        Cave cave = rockParser.parse(input);
        SandFlow sandFlow = new SandFlow();
        int sands = sandFlow.flowSandWithBottom(cave);
        System.out.println("Number of units of sand that come to rest until the source of the sand becomes blocked: " + sands);

    }

    public static void main(String[] args) {
        new RegolithReservoirSolution().run();
    }
}

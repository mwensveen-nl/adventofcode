package nl.mwensveen.adventofcode.year_2024.day_08;

import com.google.common.collect.Multimap;
import java.util.List;
import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class ResonantCollinearitySolution extends AbstractTimedSolution {

    private List<String> input;
    private Multimap<String, Position> antennaGrid;
    private int rows;
    private int cols;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_08.txt");
        AntennaParser antennaParser = new AntennaParser();
        antennaGrid = antennaParser.parse(input);
        rows = input.size();
        cols = input.getFirst().length();

    }

    @Override
    protected void part1() {
        AntinodesFinder antinodesFinder = new AntinodesFinder();
        long l = antinodesFinder.find(antennaGrid, rows, cols);
        System.out.println("Number of unique locations within the bounds of the map contain an antinode:" + l);
    }

    @Override
    protected void part2() {
        AntinodesFinder antinodesFinder = new AntinodesFinder();
        long l = antinodesFinder.findResonantHarmonic(antennaGrid, rows, cols);
        System.out.println("Number of unique locations within the bounds of the map contain an antinode wit the effects of resonant harmonics:" + l);
    }

    public static void main(String[] args) {
        new ResonantCollinearitySolution().run();
    }
}

package nl.mwensveen.adventofcode.year_2024.day_08;

import com.google.common.collect.Multimap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AntinodesFinderTest {
    private String input = """
            ............
            ........0...
            .....0......
            .......0....
            ....0.......
            ......A.....
            ............
            ............
            ........A...
            .........A..
            ............
            ............
                    """;

    @Test
    public void find() {
        AntennaParser antennaParser = new AntennaParser();
        Multimap<String, Position> grid = antennaParser.parse(input.lines().toList());

        int rows = input.lines().toList().size();
        int cols = input.lines().toList().getFirst().length();
        AntinodesFinder antinodesFinder = new AntinodesFinder();
        long result = antinodesFinder.find(grid, rows, cols);

        assertEquals(14, result);
    }

    @Test
    public void findResonantHarmonic() {
        AntennaParser antennaParser = new AntennaParser();
        Multimap<String, Position> grid = antennaParser.parse(input.lines().toList());

        int rows = input.lines().toList().size();
        int cols = input.lines().toList().getFirst().length();
        AntinodesFinder antinodesFinder = new AntinodesFinder();
        long result = antinodesFinder.findResonantHarmonic(grid, rows, cols);

        assertEquals(34, result);
    }

}

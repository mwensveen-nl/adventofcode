package nl.mwensveen.adventofcode.year_2021.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OctopusEnergySolverTest {

    @Test
    public void testMeasureEnergy() {
        List<String> input = Arrays.asList("5483143223",
                "2745854711",
                "5264556173",
                "6141336146",
                "6357385478",
                "4167524645",
                "2176841721",
                "6882881134",
                "4846848554",
                "5283751526");
        OctopusEnergySolver octopusEnergySolver = new OctopusEnergySolver();
        long result = octopusEnergySolver.measureEnergy(input, 100);
        assertEquals(1656L, result);
    }

    @Test
    public void testFindAllFlashes() {
        List<String> input = Arrays.asList("5483143223",
                "2745854711",
                "5264556173",
                "6141336146",
                "6357385478",
                "4167524645",
                "2176841721",
                "6882881134",
                "4846848554",
                "5283751526");
        OctopusEnergySolver octopusEnergySolver = new OctopusEnergySolver();
        long result = octopusEnergySolver.findAllFlashes(input);
        assertEquals(195, result);
    }

}

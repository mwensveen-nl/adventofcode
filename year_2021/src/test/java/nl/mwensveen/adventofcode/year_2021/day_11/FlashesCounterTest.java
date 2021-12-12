package nl.mwensveen.adventofcode.year_2021.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FlashesCounterTest {

    @Test
    public void testCountFlashes() {
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
        OctopusGridParser parser = new OctopusGridParser();
        Table<Integer, Integer, Octopus> grid = parser.parseGrid(input);

        EnergyProcessor energyProcessor = new EnergyProcessor();
        energyProcessor.procesEnergy(grid);
        energyProcessor.procesEnergy(grid);
        energyProcessor.procesEnergy(grid);
        energyProcessor.procesEnergy(grid);
        energyProcessor.procesEnergy(grid);
        energyProcessor.procesEnergy(grid);
        energyProcessor.procesEnergy(grid);
        energyProcessor.procesEnergy(grid);
        energyProcessor.procesEnergy(grid);
        energyProcessor.procesEnergy(grid);

        FlashesCounter flashesCounter = new FlashesCounter();
        assertEquals(204L, flashesCounter.countFlashes(grid));
    }

}

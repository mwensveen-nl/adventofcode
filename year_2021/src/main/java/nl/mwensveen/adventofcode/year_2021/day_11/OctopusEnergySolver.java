package nl.mwensveen.adventofcode.year_2021.day_11;

import com.google.common.collect.Table;
import java.util.List;

public class OctopusEnergySolver {

    long measureEnergy(List<String> input, int steps) {
        Table<Integer, Integer, Octopus> grid = new OctopusGridParser().parseGrid(input);
        EnergyProcessor energyProcessor = new EnergyProcessor();
        for (int i = 0; i < steps; i++) {
            energyProcessor.procesEnergy(grid);
        }
        FlashesCounter flashesCounter = new FlashesCounter();
        return flashesCounter.countFlashes(grid);
    }

    int findAllFlashes(List<String> input) {
        Table<Integer, Integer, Octopus> grid = new OctopusGridParser().parseGrid(input);
        EnergyProcessor energyProcessor = new EnergyProcessor();

        int x = 0;
        do {
            energyProcessor.procesEnergy(grid);
            x++;
        } while (!grid.values().stream().allMatch(o -> o.getEnergy() == 0));

        return x;
    }

}

package nl.mwensveen.adventofcode.year_2021.day_11;

import com.google.common.collect.Table;

public class EnergyProcessor {

    public void procesEnergy(Table<Integer, Integer, Octopus> grid) {
        grid.values().forEach(o -> o.increaseEnergy());
        boolean done = false;
        while (!done) {
            done = true;
            for (int r = 0; r < 10; r++) {
                for (int c = 0; c < 10; c++) {
                    Octopus octopus = grid.get(r, c);
                    if (!octopus.isFlashed() && octopus.getEnergy() > 9) {
                        done = false;
                        octopus.flash();
                        increaseOctopus(r - 1, c - 1, grid);
                        increaseOctopus(r - 1, c, grid);
                        increaseOctopus(r - 1, c + 1, grid);
                        increaseOctopus(r, c - 1, grid);
                        increaseOctopus(r, c + 1, grid);
                        increaseOctopus(r + 1, c - 1, grid);
                        increaseOctopus(r + 1, c, grid);
                        increaseOctopus(r + 1, c + 1, grid);
                    }
                }
            }
        }
        grid.values().forEach(o -> o.resetFlash());
    }

    private void increaseOctopus(int r, int c, Table<Integer, Integer, Octopus> grid) {
        if (grid.contains(r, c)) {
            Octopus octopus = grid.get(r, c);
            if (!octopus.isFlashed()) {
                octopus.increaseEnergy();
            }
        }
    }

}

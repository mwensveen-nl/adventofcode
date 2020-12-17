package nl.mwensveen.adventofcode.year_2020.day_17;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;
import nl.mwensveen.adventofcode.year_2020.day_17.Grid.State;

public class ConwayCubesSolution extends AbstractTimedSolution {
    private List<String> input;

    public static void main(String[] args) {
        new ConwayCubesSolution().run();
    }

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_17.txt");

    }

    @Override
    protected void part1() {
        GridParser gridParser = new GridParser();
        Grid grid = gridParser.parse(input);
        Cycle cycle = new Cycle();
        for (int i = 0; i < 6; i++) {
            grid = cycle.performCycle3D(grid);
        }

        long count = 0;
        for (int x = grid.getMinX(); x <= grid.getMaxX(); x++) {
            for (int y = grid.getMinY(); y <= grid.getMaxY(); y++) {
                for (int z = grid.getMinZ(); z <= grid.getMaxZ(); z++) {
                    if (grid.get(x, y, z) == State.ACTIVE) {
                        count++;
                    }
                }
            }
        }
        System.out.println("Number of cubes left in the active state after the sixth cycle in 4 dimensions = " + count);
    }

    @Override
    protected void part2() {
        GridParser gridParser = new GridParser();
        Grid grid = gridParser.parse(input);
        Cycle cycle = new Cycle();
        for (int i = 0; i < 6; i++) {
            grid = cycle.performCycle4D(grid);
        }

        long count = 0;
        for (int x = grid.getMinX(); x <= grid.getMaxX(); x++) {
            for (int y = grid.getMinY(); y <= grid.getMaxY(); y++) {
                for (int z = grid.getMinZ(); z <= grid.getMaxZ(); z++) {
                    for (int w = grid.getMinW(); w <= grid.getMaxW(); w++) {
                        if (grid.get(x, y, z, w) == State.ACTIVE) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println("Number of cubes left in the active state after the sixth cycle in 4 dimensions = " + count);
    }

}

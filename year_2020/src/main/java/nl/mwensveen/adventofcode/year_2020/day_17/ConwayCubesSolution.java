package nl.mwensveen.adventofcode.year_2020.day_17;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;
import nl.mwensveen.adventofcode.year_2020.day_17.Grid3D.State;

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
        Grid3DParser gridParser = new Grid3DParser();
        Grid3D grid = gridParser.parse(input);
        Cycle3D cycle = new Cycle3D();
        for (int i = 0; i < 6; i++) {
            grid = cycle.performCycle(grid);
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
        System.out.println("Number of cubes left in the active state after the sixth cycle = " + count);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

}

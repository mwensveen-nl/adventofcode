package nl.mwensveen.adventofcode.year_2020.day_17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.base.Strings;
import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.day_17.Grid.State;
import org.junit.jupiter.api.Test;

public class CycleTest {

    @Test
    public void testPerformCycle3D() throws Exception {
        List<String> input = Arrays.asList(".#.", "..#", "###");
        GridParser parser = new GridParser();
        Grid grid = parser.parse(input);

        Cycle cycle = new Cycle();
        grid = cycle.performCycle3D(grid);
        grid = cycle.performCycle3D(grid);
        grid = cycle.performCycle3D(grid);
        grid = cycle.performCycle3D(grid);
        grid = cycle.performCycle3D(grid);
        grid = cycle.performCycle3D(grid);

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
        assertEquals(112L, count);
    }

    private void print(Grid grid) {
        for (int w = grid.getMinW(); w <= grid.getMaxW(); w++) {
            for (int z = grid.getMinZ(); z <= grid.getMaxZ(); z++) {
                System.out.println("z=" + z + " w=" + w);
                for (int x = grid.getMinX(); x <= grid.getMaxX(); x++) {
                    System.out.print(Strings.padStart("" + x, 3, ' ') + " ");
                    for (int y = grid.getMinY(); y <= grid.getMaxY(); y++) {
                        System.out.print(grid.get(x, y, z, w) == State.ACTIVE ? "#" : ".");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }

    @Test
    public void testPerformCycle4D() throws Exception {
        List<String> input = Arrays.asList(".#.", "..#", "###");
        GridParser parser = new GridParser();
        Grid grid = parser.parse(input);
        print(grid);

        Cycle cycle = new Cycle();
        grid = cycle.performCycle4D(grid);
        System.out.println("done");
        print(grid);
        grid = cycle.performCycle4D(grid);
        grid = cycle.performCycle4D(grid);
        grid = cycle.performCycle4D(grid);
        grid = cycle.performCycle4D(grid);
        grid = cycle.performCycle4D(grid);

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
        assertEquals(848, count);
    }

}

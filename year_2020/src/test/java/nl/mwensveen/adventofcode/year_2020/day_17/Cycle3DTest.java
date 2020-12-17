package nl.mwensveen.adventofcode.year_2020.day_17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.base.Strings;
import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.day_17.Grid3D.State;
import org.junit.jupiter.api.Test;

public class Cycle3DTest {

    @Test
    public void testPerformCycle() throws Exception {
        List<String> input = Arrays.asList(".#.", "..#", "###");
        Grid3DParser parser = new Grid3DParser();
        Grid3D grid = parser.parse(input);
        print(grid);
        Cycle3D cycle = new Cycle3D();
        grid = cycle.performCycle(grid);
        grid = cycle.performCycle(grid);
        grid = cycle.performCycle(grid);
        grid = cycle.performCycle(grid);
        grid = cycle.performCycle(grid);
        grid = cycle.performCycle(grid);

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

    private void print(Grid3D grid) {
        for (int z = grid.getMinZ(); z <= grid.getMaxZ(); z++) {
            System.out.println("z=" + z);
            for (int x = grid.getMinX(); x <= grid.getMaxX(); x++) {
                System.out.print(Strings.padStart("" + x, 3, ' ') + " ");
                for (int y = grid.getMinY(); y <= grid.getMaxY(); y++) {
                    System.out.print(grid.get(x, y, z) == State.ACTIVE ? "#" : ".");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}

package nl.mwensveen.adventofcode.year_2020.day_17;

import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.day_17.Grid.State;
import org.junit.jupiter.api.Test;

public class CycleTest {

    @Test
    public void testPerformCycle() throws Exception {
        List<String> input = Arrays.asList(".#.", "..#", "###");
        GridParser parser = new GridParser();
        Grid grid = parser.parse(input);
        Cycle cycle = new Cycle();
        grid = cycle.performCycle(grid);
        for (int z = grid.getMinZ(); z <= grid.getMaxZ(); z++) {
            System.out.println("z=" + z);
            for (int x = grid.getMinX(); x <= grid.getMaxX(); x++) {
                for (int y = grid.getMinY(); y <= grid.getMaxY(); y++) {
                    System.out.print(grid.get(x, y, z) == State.ACTIVE ? "#" : ".");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}

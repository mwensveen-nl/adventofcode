package nl.mwensveen.adventofcode.year_2020.day_17;

import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.day_17.Grid3D.State;
import org.junit.jupiter.api.Test;

public class Grid3DParserTest {

    @Test
    public void testParse() throws Exception {
        List<String> input = Arrays.asList(".#.", "..#", "###");
        Grid3DParser parser = new Grid3DParser();
        Grid3D grid = parser.parse(input);
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

package nl.mwensveen.adventofcode.year_2020.day_17;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;
import java.util.List;

public class Grid3DParser {
    public Grid3D parse(List<String> input) {
        Grid3D grid = new Grid3D();
        StreamUtils.zipWithIndex(input.stream()).forEach(e -> process(e, grid));
        return grid;
    }

    private void process(Indexed<String> e, Grid3D grid) {
        int z = 0;
        int x = Long.valueOf(e.getIndex()).intValue();
        String[] split = e.getValue().split("");
        for (int y = 0; y < split.length; y++) {
            String s = split[y];
            if (s.equals("#")) {
                grid.activate(x, y, z);
            } else {
                grid.deActivate(x, y, z);
            }
        }
    }
}

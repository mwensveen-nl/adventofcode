package nl.mwensveen.adventofcode.year_2020.day_17;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;
import java.util.List;

public class GridParser {
    public Grid parse(List<String> input) {
        Grid grid = new Grid();
        StreamUtils.zipWithIndex(input.stream()).forEach(e -> process(e, grid));
        return grid;
    }

    private void process(Indexed<String> e, Grid grid) {
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

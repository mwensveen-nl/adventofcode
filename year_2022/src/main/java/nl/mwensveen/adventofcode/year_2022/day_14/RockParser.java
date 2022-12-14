package nl.mwensveen.adventofcode.year_2022.day_14;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RockParser {

    private Table<Integer, Integer, String> rocks = HashBasedTable.create();
    private int xMin = Integer.MAX_VALUE;
    private int xMax = Integer.MIN_VALUE;
    private int yMin = Integer.MAX_VALUE;
    private int yMax = Integer.MIN_VALUE;

    public Cave parse(List<String> input) {
        input.stream().forEach(s -> drawRocks(s));
        return Cave.builder().withRocks(rocks).withXMin(xMin).withXMax(xMax).withYMin(yMin).withYMax(yMax).build();
    }

    private Object drawRocks(String s) {
        String[] split = s.split("->");
        Arrays.stream(split).reduce("", (one, two) -> drawRocks(one, two));
        return null;
    }

    private String drawRocks(String one, String two) {
        String[] split = two.trim().split(",");
        int x2 = Integer.valueOf(split[0]);
        int y2 = Integer.valueOf(split[1]);
        if (!one.isBlank()) {
            split = one.trim().split(",");
            int x1 = Integer.valueOf(split[0]);
            int y1 = Integer.valueOf(split[1]);

            IntStream.rangeClosed(Math.min(x1, x2), Math.max(x1, x2)).forEach(x -> IntStream.rangeClosed(Math.min(y1, y2), Math.max(y1, y2)).forEach(y -> rocks.put(x, y, "#")));
        }
        xMin = Math.min(xMin, x2);
        xMax = Math.max(xMax, x2);
        yMin = Math.min(yMin, y2);
        yMax = Math.max(yMax, y2);

        return two;
    }
}

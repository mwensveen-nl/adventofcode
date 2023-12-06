package nl.mwensveen.adventofcode.year_2023.day_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record AlmanacSeedRanges(List<Long> seeds, List<Conversion> conversions) {

    public static AlmanacSeedRanges parse(String line) {
        List<Long> seeds = Arrays.stream(line.split(" ")).skip(1).map(Long::valueOf).toList();
        return new AlmanacSeedRanges(seeds, new ArrayList<Conversion>());
    }
}

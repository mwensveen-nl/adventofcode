package nl.mwensveen.adventofcode.year_2023.day_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record AlmanacSeeds(List<Long> seeds, List<Conversion> conversions) {

    public static AlmanacSeeds parse(String line) {
        List<Long> seeds = Arrays.stream(line.split(" ")).skip(1).map(Long::valueOf).toList();
        return new AlmanacSeeds(seeds, new ArrayList<Conversion>());
    }
}

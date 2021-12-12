package nl.mwensveen.adventofcode.year_2021.day_11;

import com.google.common.collect.Table;
import java.util.stream.Collectors;

public class FlashesCounter {

    long countFlashes(Table<Integer, Integer, Octopus> grid) {
        return grid.values().stream().collect(Collectors.summingLong(Octopus::getNumberOfFlashes));
    }
}

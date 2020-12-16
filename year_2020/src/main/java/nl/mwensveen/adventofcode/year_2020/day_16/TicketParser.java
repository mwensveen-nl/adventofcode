package nl.mwensveen.adventofcode.year_2020.day_16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TicketParser {

    public List<Integer> parse(String input) {
        String[] split = input.split(",");
        return Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toList());
    }
}

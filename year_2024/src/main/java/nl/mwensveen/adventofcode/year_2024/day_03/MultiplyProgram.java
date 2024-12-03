package nl.mwensveen.adventofcode.year_2024.day_03;

import java.util.List;
import java.util.stream.Collectors;

public class MultiplyProgram {

    public long multiply(List<Mutiply> mutipliers) {
        return mutipliers.stream().peek(System.out::println).collect(Collectors.summingLong(m -> m.one() * m.two()));
    }
}

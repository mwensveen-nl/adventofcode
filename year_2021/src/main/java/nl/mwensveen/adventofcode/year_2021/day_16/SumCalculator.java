package nl.mwensveen.adventofcode.year_2021.day_16;

import java.util.List;
import java.util.stream.Collectors;

public class SumCalculator implements Calculator {

    @Override
    public Long calculateValue(List<Packet> packets) {
        return packets.stream().map(p -> p.getValue()).collect(Collectors.summingLong(l -> l));
    }
}

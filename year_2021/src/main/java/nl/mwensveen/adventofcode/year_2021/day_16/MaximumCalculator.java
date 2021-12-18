package nl.mwensveen.adventofcode.year_2021.day_16;

import java.util.List;

public class MaximumCalculator implements Calculator {

    @Override
    public Long calculateValue(List<Packet> packets) {
        return packets.stream().map(p -> p.getValue()).max(Long::compare).get();
    }

}

package nl.mwensveen.adventofcode.year_2021.day_16;

import java.util.List;

public class EqualToCalculator implements Calculator {

    @Override
    public Long calculateValue(List<Packet> packets) {
        return packets.get(0).getValue() == packets.get(1).getValue() ? 1L : 0L;
    }

}

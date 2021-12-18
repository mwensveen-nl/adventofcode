package nl.mwensveen.adventofcode.year_2021.day_16;

import java.util.List;

public class ProductCalculator implements Calculator {

    @Override
    public Long calculateValue(List<Packet> packets) {
        long result = 1;
        for (Packet packet : packets) {
            result = result * packet.getValue();
        }
        return result;
    }

}

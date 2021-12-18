package nl.mwensveen.adventofcode.year_2021.day_16;

import java.util.List;

public interface OperatorPacket extends Packet {

    List<Packet> getSubPackets();

    @Override
    default long getValue() {
        Calculator calculator = switch (getTypeId()) {
            case 0 -> new SumCalculator();
            case 1 -> new ProductCalculator();
            case 2 -> new MinimumCalculator();
            case 3 -> new MaximumCalculator();
            case 5 -> new GreaterThanCalculator();
            case 6 -> new LessThanCalculator();
            case 7 -> new EqualToCalculator();
            default -> throw new IllegalArgumentException("Unexpected value: " + getTypeId());
        };
        return calculator.calculateValue(getSubPackets());
    }
}
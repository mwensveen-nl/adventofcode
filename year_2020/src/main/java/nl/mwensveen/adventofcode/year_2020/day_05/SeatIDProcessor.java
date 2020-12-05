package nl.mwensveen.adventofcode.year_2020.day_05;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SeatIDProcessor {

    public int findHighestSeatId(List<String> input) {
        SeatIDCalculator seatIDCalculator = new SeatIDCalculator();
        return input.stream().map(seatIDCalculator::calcSeatId).max(Comparator.naturalOrder()).get();
    }

    public int findMySeatId(List<String> input, int max) {
        SeatIDCalculator seatIDCalculator = new SeatIDCalculator();
        List<Integer> seatIds = input.stream().map(seatIDCalculator::calcSeatId).sorted().collect(Collectors.toList());

        for (int i = 1; i < max - 1; i++) {
            if (!seatIds.contains(Integer.valueOf(i))) {
                if (seatIds.contains(Integer.valueOf(i + 1)) && seatIds.contains(Integer.valueOf(i - 1))) {
                    return i;
                }
            }
        }
        throw new RuntimeException("Seatid not found");
    }
}
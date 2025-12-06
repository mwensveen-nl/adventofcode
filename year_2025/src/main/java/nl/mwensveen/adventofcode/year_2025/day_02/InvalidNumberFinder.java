package nl.mwensveen.adventofcode.year_2025.day_02;

import java.math.BigInteger;
import java.util.List;

public class InvalidNumberFinder {

    public BigInteger findDoubles(List<Range> ranges) {
        return ranges.stream().map(this::findDoublesRange).reduce(BigInteger.ZERO, BigInteger::add);
    }

    private BigInteger findDoublesRange(Range r) {
        long start = r.start();
        var startString = Long.toString(start);
        if (startString.length() % 2 == 1) {
            startString = "1" + "0".repeat(startString.length());
        }
        String first = startString.substring(0, startString.length() / 2);
        var number = Long.valueOf(first);

        var sum = BigInteger.ZERO;
        var doubleNumber = Long.valueOf(Long.toString(number) + Long.toString(number));
        while (!r.larger(doubleNumber)) {
            if (r.inRange(doubleNumber)) {
                sum = sum.add(BigInteger.valueOf(doubleNumber));
            }
            number++;
            doubleNumber = Long.valueOf(Long.toString(number) + Long.toString(number));
        }
        return sum;
    }

}

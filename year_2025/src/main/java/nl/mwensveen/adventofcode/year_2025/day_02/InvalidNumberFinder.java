package nl.mwensveen.adventofcode.year_2025.day_02;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

public class InvalidNumberFinder {

    private final static String REGEXP = "^(.+?)\\1+$";
    private final static Pattern GROUP_PATTERN = Pattern.compile(REGEXP);

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

    public BigInteger findRepeats(List<Range> ranges) {
        return ranges.stream().map(this::findRepeatsRange).reduce(BigInteger.ZERO, BigInteger::add);
    }

    private BigInteger findRepeatsRange(Range range) {
        return LongStream.rangeClosed(range.start(), range.end())
                .filter(this::findRepeatLong)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private boolean findRepeatLong(long long1) {
        return GROUP_PATTERN.matcher(Long.toString(long1)).find();
    }
}

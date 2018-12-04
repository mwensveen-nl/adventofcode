package nl.mwensveen.adventofcode.year_2018.day_2;

import java.util.List;

public class ChecksumCalculator {
    private static final int TWO_INDEX = 0;
    private static final int THREE_INDEX = 1;
    private List<String> input;
    private long[] twoThree = new long[2];

    public ChecksumCalculator(List<String> input) {
        this.input = input;
    }

    public long calculate() {
        input.stream().map(BoxAnalyser::new).forEach(ba -> {
            if (ba.twoTimes()) {
                twoThree[TWO_INDEX]++;
            }
            if (ba.threeTimes()) {
                twoThree[THREE_INDEX]++;
            }
        });

        return twoThree[TWO_INDEX] * twoThree[THREE_INDEX];
    }

    public String findDiffOneChar() {
        return null;
    }
}

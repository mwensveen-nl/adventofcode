package nl.mwensveen.adventofcode.year_2017.day_1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InverseCaptchaPart {

    private String numberString;
    private int compareCount;

    public InverseCaptchaPart(String numberString, int compareCount) {
        this.numberString = numberString;
        this.compareCount = compareCount;
    }

    public Integer calculate() {

        return IntStream.range(0, numberString.length()).mapToObj(i -> createPair(i)).filter(Pair::matches).collect(Collectors.summingInt(p -> p.getOne()));
    }

    private Pair createPair(int i) {
        int count = i + compareCount;
        if (count > numberString.length() - 1) {
            count = count - numberString.length();
        }
        return new Pair(Integer.valueOf(numberString.substring(i, i + 1)),
            Integer.valueOf(numberString.substring(count, count + 1)));
    }
}

package nl.mwensveen.adventofcode.year_2023.day_15;

import java.util.Arrays;

public class InitializationSequenceProcessor {

    public long process(String input) {
        HashAlgorithm algorithm = new HashAlgorithm();
        String[] strings = input.split(",");
        long sum = Arrays.stream(strings).mapToLong(algorithm::calculateHash).sum();
        return sum;

    }
}

package nl.mwensveen.adventofcode.year_2023.day_05;

import java.util.List;

public record ConversionRange(Long destinationStart, Long sourceStart, Long range) {

    public boolean containsSource(Long source) {
        return source >= sourceStart && source < sourceStart + range;
    }

    public Long calculateDestination(Long source) {
        return source - sourceStart + destinationStart;
    }

    public static ConversionRange parse(String line) {
        String[] split = line.split(" ");
        return new ConversionRange(Long.valueOf(split[0]), Long.valueOf(split[1]), Long.valueOf(split[2]));
    }

    public void procesRange(List<Range> input) {

    }
}

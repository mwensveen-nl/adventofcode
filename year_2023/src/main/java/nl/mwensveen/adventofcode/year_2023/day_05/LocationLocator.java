package nl.mwensveen.adventofcode.year_2023.day_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocationLocator {

    public long findLowestLocation(AlmanacSeeds almanac) {

        List<Long> numbers = almanac.seeds();
        List<String> source = new ArrayList<String>();
        source.add("seed");
        while (!source.getLast().equals("location")) {
            Conversion conversion = almanac.conversions().stream().filter(c -> c.source().equals(source.getLast())).findFirst().get();
            numbers = numbers.stream().map(n -> convert(n, conversion)).toList();
            source.add(conversion.destination());
        }
        return numbers.stream().mapToLong(l -> l).min().getAsLong();
    }

    private Long convert(Long n, Conversion conversion) {
        Optional<ConversionRange> first = conversion.conversionRanges().stream().filter(cr -> cr.containsSource(n)).findFirst();
        if (first.isPresent()) {
            return first.get().calculateDestination(n);
        } else {
            return n;
        }
    }
}

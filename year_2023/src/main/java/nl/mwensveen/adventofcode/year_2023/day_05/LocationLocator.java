package nl.mwensveen.adventofcode.year_2023.day_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocationLocator {

	public long findLowestLocation(AlmanacSeeds almanac) {

		List<Long> numbers = almanac.seeds();
		List<String> sourceList = new ArrayList<String>(); // needed because in Lambda an attribute must be final.
		sourceList.add("seed");
		while (!sourceList.getLast().equals("location")) {
			Conversion conversion = almanac.conversions().stream().filter(c -> c.source().equals(sourceList.getLast())).findFirst().get();
			numbers = numbers.stream().map(n -> convert(n, conversion)).toList();
			sourceList.add(conversion.destination());
		}
		return numbers.stream().mapToLong(l -> l).min().getAsLong();
	}

	private Long convert(Long n, Conversion conversion) {
		Optional<ConversionRange> first = conversion.conversionRanges().stream().filter(cr -> cr.containsSource(n)).findFirst();
		if (first.isPresent()) {
			return first.get().calculateDestination(n);
		}
		return n;
	}

	public long findLowestLocationWithRanges(AlmanacSeedRanges almanac) {

		List<Range> sourceRanges = almanac.seeds();
		List<String> sourceList = new ArrayList<String>();
		sourceList.add("seed");
		while (!sourceList.getLast().equals("location")) {
			Conversion conversion = almanac.conversions().stream().filter(c -> c.source().equals(sourceList.getLast())).findFirst().get();

			List<ConversionRange> conversionRanges = conversion.conversionRanges();
			List<Range> destinationRanges = new ArrayList<>();
			for (ConversionRange conversionRange : conversionRanges) {
				List<List<Range>> processedRanges = conversionRange.processSourceRanges(sourceRanges);
				sourceRanges = processedRanges.get(0);
				destinationRanges.addAll(processedRanges.get(1));
			}
			destinationRanges.addAll(sourceRanges); // not converted
			sourceRanges = destinationRanges;
			sourceList.add(conversion.destination());
		}
		return sourceRanges.stream().mapToLong(r -> r.start()).min().getAsLong();
	}
}

package nl.mwensveen.adventofcode.year_2023.day_05;

import java.util.ArrayList;
import java.util.List;

public record ConversionRange(Long destinationStart, Long sourceStart, Long sourceEnd, Long range) {

	public ConversionRange(Long destinationStart, Long sourceStart, Long range) {
		this(destinationStart, sourceStart, sourceStart + range - 1, range);
	}

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

	public List<List<Range>> processSourceRanges(List<Range> sourceRanges) {
		List<List<Range>> result = new ArrayList<>();
		List<Range> newSourceRanges = new ArrayList<>();
		List<Range> newDestinatinRanges = new ArrayList<>();
		result.add(newSourceRanges);
		result.add(newDestinatinRanges);
		for (Range sourceRange : sourceRanges) {
			if (sourceRange.end() < sourceStart || sourceRange.start() > sourceEnd) {
				newSourceRanges.add(sourceRange);
			} else {
				Long start = sourceRange.start();
				Long end = sourceRange.end();
				if (start < sourceStart) {
					if (sourceStart - start != 0L) {
						newSourceRanges.add(new Range(start, sourceStart - 1, sourceStart - start));
					}
					start = sourceStart;
				}
				if (end > sourceEnd()) {
					if (sourceEnd - end != 0L) {
						newSourceRanges.add(new Range(sourceEnd + 1, end, end - sourceEnd));
					}
					end = sourceEnd;
				}
				Long startDest = calculateDestination(start);
				Long endDest = calculateDestination(end);
				newDestinatinRanges.add(new Range(startDest, endDest, endDest - startDest + 1));
			}
		}
		return result;
	}

}

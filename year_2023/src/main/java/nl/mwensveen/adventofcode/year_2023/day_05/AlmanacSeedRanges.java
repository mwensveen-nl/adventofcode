package nl.mwensveen.adventofcode.year_2023.day_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record AlmanacSeedRanges(List<Range> seeds, List<Conversion> conversions) {

	public static AlmanacSeedRanges parse(String line) {
		List<Long> numbers = Arrays.stream(line.split(" ")).skip(1).map(Long::valueOf).toList();
		List<Range> seeds = new ArrayList<>();
		for (int i = 0; i < numbers.size(); i += 2) {
			seeds.add(new Range(numbers.get(i), numbers.get(i + 1)));
		}
		return new AlmanacSeedRanges(seeds, new ArrayList<Conversion>());
	}
}

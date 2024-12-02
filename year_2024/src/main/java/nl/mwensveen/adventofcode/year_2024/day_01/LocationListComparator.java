package nl.mwensveen.adventofcode.year_2024.day_01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LocationListComparator {

	public Integer compareLists(List<Integer> first, List<Integer> second) {
		first.sort(Comparator.naturalOrder());
		second.sort(Comparator.naturalOrder());
		int result = 0;
		for (int i = 0; i < first.size(); i++) {
			result += Math.abs(first.get(i) - second.get(i));
		}
		return result;
	}

	public Integer similarityScore(List<Integer> first, List<Integer> second) {
		Map<Integer, Integer> counts = new HashMap<>();
		second.forEach(i -> counts.put(i, counts.getOrDefault(i, 0) + 1));

		AtomicInteger score = new AtomicInteger();
		first.forEach(i -> score.addAndGet(i * counts.getOrDefault(i, 0)));

		return score.get();
	}
}

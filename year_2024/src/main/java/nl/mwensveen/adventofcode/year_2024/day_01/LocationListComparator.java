package nl.mwensveen.adventofcode.year_2024.day_01;

import java.util.Comparator;
import java.util.List;

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
}

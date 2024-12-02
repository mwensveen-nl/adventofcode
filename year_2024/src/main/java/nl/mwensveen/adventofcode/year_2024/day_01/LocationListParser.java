package nl.mwensveen.adventofcode.year_2024.day_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationListParser {

	public List<List<Integer>> readLists(List<String> input) {

		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();

		input.forEach(line -> {
			String[] split = line.trim().replaceAll(" +", " ").split(" ");
			first.add(Integer.valueOf(split[0]));
			second.add(Integer.valueOf(split[1]));
		});

		return Collections.unmodifiableList(List.of(first, second));
	}
}

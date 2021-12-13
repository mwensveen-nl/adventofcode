package nl.mwensveen.adventofcode.year_2021.day_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaveParser {

	Map<String, List<String>> parseCaves(List<String> input) {
		Map<String, List<String>> caves = new HashMap<>();
		input.forEach(line -> addToCaves(line, caves));
		return caves;
	}

	private void addToCaves(String line, Map<String, List<String>> caves) {
		String[] split = line.split("-");

		if (!caves.containsKey(split[0])) {
			caves.put(split[0], new ArrayList<>());
		}
		caves.get(split[0]).add(split[1]);

		if (!caves.containsKey(split[1])) {
			caves.put(split[1], new ArrayList<>());
		}
		caves.get(split[1]).add(split[0]);
	}
}

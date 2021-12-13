package nl.mwensveen.adventofcode.year_2021.day_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CaveWalker {

	int findPaths(Map<String, List<String>> caves) {
		List<String> currentPath = new ArrayList<>();
		List<String> connections = caves.get("start");
		List<String> foundPaths = findPaths(connections, currentPath, caves);
		return foundPaths.size();
	}

	private List<String> findPaths(List<String> connections, List<String> currentPath, Map<String, List<String>> caves) {
		List<String> foundPaths = new ArrayList<>();
		for (String nextCave : connections) {
			if (!nextCave.toLowerCase().equals(nextCave) && currentPath.contains(nextCave)) {
				List<String> newPath = new ArrayList<>(currentPath);
				newPath.add(nextCave);
				if (nextCave.equals("end")) {
					foundPaths.add(String.join(",", newPath));
				} else {
					foundPaths.addAll(findPaths(caves.get(nextCave), newPath, caves));
				}
			}
		}
		return foundPaths;
	}

}

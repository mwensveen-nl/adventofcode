package nl.mwensveen.adventofcode.year_2021.day_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CaveWalker {

	public Integer findAllPaths(Map<String, List<String>> caves, boolean doubleVisitSmallCaveAllowed) {
		List<String> connections = caves.get("start");
		List<String> currentPath = new ArrayList<>();
		List<String> foundPaths = null;
		currentPath.add("start");

		if (!doubleVisitSmallCaveAllowed) {
			foundPaths = findPaths(connections, currentPath, caves);
		} else {
			foundPaths = findPaths(connections, currentPath, caves, false);
		}
		return foundPaths.size();
	}

	private List<String> findPaths(List<String> connections, List<String> currentPath, Map<String, List<String>> caves) {
		List<String> foundPaths = new ArrayList<>();

		if (currentPath.contains("end")) {
			foundPaths.add(String.join(",", currentPath));
			return foundPaths;
		}

		for (String nextCave : connections) {
			if (currentPath.contains(nextCave) && nextCave.toLowerCase().equals(nextCave)) {
				// nothing to do
			} else {
				List<String> newPath = new ArrayList<>(currentPath);
				newPath.add(nextCave);
				foundPaths.addAll(findPaths(caves.get(nextCave), newPath, caves));
			}
		}
		return foundPaths;
	}

	private List<String> findPaths(List<String> connections, List<String> currentPath, Map<String, List<String>> caves, boolean doubleVisited) {
		List<String> foundPaths = new ArrayList<>();

		if (currentPath.contains("end")) {
			foundPaths.add(String.join(",", currentPath));
			return foundPaths;
		}
		for (String nextCave : connections) {
			boolean newDoubleVisisted = doubleVisited;
			if (currentPath.contains(nextCave) && nextCave.toLowerCase().equals(nextCave)) {
				if (newDoubleVisisted || nextCave.equals("start")) {
					continue;
				} else {
					newDoubleVisisted = true;
				}
			}
			List<String> newPath = new ArrayList<>(currentPath);
			newPath.add(nextCave);
			foundPaths.addAll(findPaths(caves.get(nextCave), newPath, caves, newDoubleVisisted));

		}
		return foundPaths;
	}

}

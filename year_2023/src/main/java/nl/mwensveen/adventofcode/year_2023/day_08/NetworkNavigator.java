package nl.mwensveen.adventofcode.year_2023.day_08;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NetworkNavigator {

	public long navigate(Instructions instructions) {
		long count = 0;
		List<String> instruction = instructions.instruction();
		Map<String, LeftRight> nodes = instructions.nodes();

		String currentElement = "AAA";

		int i = 0;
		while (!currentElement.equals("ZZZ")) {
			LeftRight leftRight = nodes.get(currentElement);
			String lr = instruction.get(i);
			if (lr.equals("L")) {
				currentElement = leftRight.left();
			} else {
				currentElement = leftRight.right();
			}
			i++;
			if (i >= instruction.size()) {
				i = 0;
			}
			count++;
		}
		return count;
	}

	public long navigateMultipleNodes(Instructions instructions) {
		List<String> instruction = instructions.instruction();
		Map<String, LeftRight> nodes = instructions.nodes();

		Set<String> currentElements = findAllANodes(nodes);

		return currentElements.stream().map(n -> findZNode(n, instruction, nodes)).reduce(1L, (lcm, count) -> LCM.lcm(lcm, count));

	}

	private long findZNode(String start, List<String> instruction, Map<String, LeftRight> nodes) {
		int i = 0;
		long count = 0;
		String element = start;
		while (!element.endsWith("Z")) {
			LeftRight leftRight = nodes.get(element);
			String lr = instruction.get(i);
			if (lr.equals("L")) {
				element = leftRight.left();
			} else {
				element = leftRight.right();
			}
			i++;
			if (i >= instruction.size()) {
				i = 0;
			}
			count++;
		}
		return count;
	}

	private Set<String> findAllANodes(Map<String, LeftRight> nodes) {
		return nodes.keySet().stream().filter(n -> n.endsWith("A")).collect(Collectors.toSet());
	}
}

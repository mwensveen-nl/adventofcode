package nl.mwensveen.adventofcode.year_2022.day_05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

public class StacksCreator {

	public Map<Integer, Stack<String>> createStacks(List<String> input) {
		Map<Integer, Stack<String>> stacks = new HashMap<>();

		int size = input.size() - 1;
		IntStream.rangeClosed(1, size).forEach(i -> addToStacks(input.get(size - i), stacks));

		return stacks;
	}

	private void addToStacks(String line, Map<Integer, Stack<String>> stacks) {
		int numberOfStacks = (line.length() + 1) / 4;
		IntStream.rangeClosed(1, numberOfStacks).forEach(i -> addToStack(line.substring((i - 1) * 4 + 1, (i - 1) * 4 + 2), getStack(stacks, i)));
	}

	private Stack<String> getStack(Map<Integer, Stack<String>> stacks, int i) {
		if (!stacks.containsKey(i)) {
			stacks.put(i, new Stack<>());
		}
		return stacks.get(i);

	}

	private void addToStack(String crate, Stack<String> stack) {
		if (!crate.isBlank()) {
			stack.push(crate);
		}
	}
}

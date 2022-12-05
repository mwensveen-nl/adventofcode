package nl.mwensveen.adventofcode.year_2022.day_05;

import java.util.Map;
import java.util.Stack;

public class StacksInspector {

	public String inpectTopCratesOfStacks(Map<Integer, Stack<String>> stacks) {
		StringBuilder sb = new StringBuilder();
		stacks.values().forEach(s -> sb.append(s.peek()));
		return sb.toString();
	}
}

package nl.mwensveen.adventofcode.year_2022.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class StacksInspectorTest {

	@Test
	public void testInpectTopCratesOfStacks() {
		Map<Integer, Stack<String>> stacks = new HashMap<>();
		Stack<String> stack = new Stack<>();
		stack.push("Z");
		stack.push("N");
		stacks.put(1, stack);
		stack = new Stack<>();
		stack.push("M");
		stack.push("C");
		stack.push("D");
		stacks.put(2, stack);
		stack = new Stack<>();
		stack.push("P");
		stacks.put(3, stack);

		StacksInspector inspector = new StacksInspector();
		String crates = inspector.inpectTopCratesOfStacks(stacks);
		assertEquals("NDP", crates);
	}

}

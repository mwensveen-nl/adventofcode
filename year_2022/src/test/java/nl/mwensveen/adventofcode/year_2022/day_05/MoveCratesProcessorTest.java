package nl.mwensveen.adventofcode.year_2022.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class MoveCratesProcessorTest {

	private String input = """
			move 1 from 2 to 1
			move 3 from 1 to 3
			move 2 from 2 to 1
			move 1 from 1 to 2
						""";

	private MoveCratesProcessor processor = new MoveCratesProcessor();

	@Test
	public void testMoveCratesOneCrateAtATimeOneCrate() {
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

		processor.moveCratesOneCrateAtATime("move 1 from 2 to 1", stacks);

		assertEquals("D", stacks.get(1).pop());
		assertEquals("N", stacks.get(1).pop());
		assertEquals("Z", stacks.get(1).pop());
		assertTrue(stacks.get(1).isEmpty());

		assertEquals("C", stacks.get(2).pop());
		assertEquals("M", stacks.get(2).pop());
		assertTrue(stacks.get(2).isEmpty());

		assertEquals("P", stacks.get(3).pop());
		assertTrue(stacks.get(3).isEmpty());
	}

	@Test
	public void testMoveCratesOneCrateAtATimeTwoCrate() {
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

		processor.moveCratesOneCrateAtATime("move 2 from 2 to 1", stacks);

		assertEquals("C", stacks.get(1).pop());
		assertEquals("D", stacks.get(1).pop());
		assertEquals("N", stacks.get(1).pop());
		assertEquals("Z", stacks.get(1).pop());
		assertTrue(stacks.get(1).isEmpty());

		assertEquals("M", stacks.get(2).pop());
		assertTrue(stacks.get(2).isEmpty());

		assertEquals("P", stacks.get(3).pop());
		assertTrue(stacks.get(3).isEmpty());
	}

	@Test
	public void testProcessInstructionsOneCrateAtATime() {
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

		processor.processInstructionsOneCrateAtATime(input.lines().toList(), stacks);

		assertEquals("C", stacks.get(1).pop());
		assertTrue(stacks.get(1).isEmpty());

		assertEquals("M", stacks.get(2).pop());
		assertTrue(stacks.get(2).isEmpty());

		assertEquals("Z", stacks.get(3).pop());
		assertEquals("N", stacks.get(3).pop());
		assertEquals("D", stacks.get(3).pop());
		assertEquals("P", stacks.get(3).pop());
		assertTrue(stacks.get(3).isEmpty());
	}

	@Test
	public void testMoveCratesMoreCratesAtATime() {
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

		processor.moveCratesMoreCratesAtATime("move 2 from 2 to 1", stacks);

		assertEquals("D", stacks.get(1).pop());
		assertEquals("C", stacks.get(1).pop());
		assertEquals("N", stacks.get(1).pop());
		assertEquals("Z", stacks.get(1).pop());
		assertTrue(stacks.get(1).isEmpty());

		assertEquals("M", stacks.get(2).pop());
		assertTrue(stacks.get(2).isEmpty());

		assertEquals("P", stacks.get(3).pop());
		assertTrue(stacks.get(3).isEmpty());
	}

	@Test
	public void testProcessInstructionsMoreCratesAtATime() {
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

		processor.processInstructionsMoreCratesAtATime(input.lines().toList(), stacks);

		assertEquals("M", stacks.get(1).pop());
		assertTrue(stacks.get(1).isEmpty());

		assertEquals("C", stacks.get(2).pop());
		assertTrue(stacks.get(2).isEmpty());

		assertEquals("D", stacks.get(3).pop());
		assertEquals("N", stacks.get(3).pop());
		assertEquals("Z", stacks.get(3).pop());
		assertEquals("P", stacks.get(3).pop());
		assertTrue(stacks.get(3).isEmpty());
	}

}

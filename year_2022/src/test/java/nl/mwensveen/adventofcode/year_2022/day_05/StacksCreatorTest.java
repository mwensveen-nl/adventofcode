package nl.mwensveen.adventofcode.year_2022.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class StacksCreatorTest {
	private static String input = """
			    [D]
			[N] [C]
			[Z] [M] [P]
			 1   2   3
						""";

	@Test
	public void testCreateStacks() {
		StacksCreator creator = new StacksCreator();
		Map<Integer, Stack<String>> stacks = creator.createStacks(input.lines().toList());

		assertEquals(3, stacks.size());
		assertEquals("N", stacks.get(1).pop());
		assertEquals("Z", stacks.get(1).pop());
		assertTrue(stacks.get(1).isEmpty());

		assertEquals("D", stacks.get(2).pop());
		assertEquals("C", stacks.get(2).pop());
		assertEquals("M", stacks.get(2).pop());
		assertTrue(stacks.get(2).isEmpty());

		assertEquals("P", stacks.get(3).pop());
		assertTrue(stacks.get(3).isEmpty());
	}

}

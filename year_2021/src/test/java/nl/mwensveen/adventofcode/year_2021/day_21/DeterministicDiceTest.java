package nl.mwensveen.adventofcode.year_2021.day_21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeterministicDiceTest {

	@Test
	public void testNext() {
		DeterministicDice dice = new DeterministicDice();
		assertEquals(1, dice.next());
		assertEquals(2, dice.next());
		assertEquals(3, dice.next());
		assertEquals(4, dice.next());
		assertEquals(5, dice.next());
		assertEquals(6, dice.next());
		assertEquals(7, dice.next());
		assertEquals(8, dice.next());
		assertEquals(9, dice.next());
		assertEquals(10, dice.next());
		assertEquals(1, dice.next());
		assertEquals(2, dice.next());
		assertEquals(3, dice.next());
		assertEquals(4, dice.next());
		assertEquals(5, dice.next());
		assertEquals(6, dice.next());
		assertEquals(7, dice.next());
		assertEquals(8, dice.next());
		assertEquals(9, dice.next());
		assertEquals(10, dice.next());

		assertEquals(20, dice.timesThrown());
	}

}

package nl.mwensveen.adventofcode.year_2021.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LanternfishTest {

	@Test
	public void testNextDay() {
		Lanternfish f = new Lanternfish(1);

		assertFalse(f.nextDay());
		assertTrue(f.nextDay());

		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertTrue(f.nextDay());
	}

	@Test
	public void testNextDayNewFish() {
		Lanternfish f = Lanternfish.createNewFishs(2);
		assertEquals(2, f.getNumberOfFish());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertFalse(f.nextDay());
		assertTrue(f.nextDay());
	}

}

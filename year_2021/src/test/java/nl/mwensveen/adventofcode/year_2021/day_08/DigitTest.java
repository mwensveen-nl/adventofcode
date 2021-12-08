package nl.mwensveen.adventofcode.year_2021.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DigitTest {

	@Test
	public void testCount() {
		assertEquals(1, Digit.builder().withA().build().count());
		assertEquals(2, Digit.builder().withA().withB().build().count());
		assertEquals(7, Digit.builder().withA().withB().withC().withD().withE().withF().withG().build().count());
	}

	@Test
	public void testEquals() {
		assertEquals(Digit.ONE, Digit.builder().withC().withF().build());
	}

}

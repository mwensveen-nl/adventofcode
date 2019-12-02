package nl.mwensveen.adventofcode.year_2019.day_02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class OpcodeTest {

	@Test
	public void testValueOf() {
		assertEquals(Opcode.ADD, Opcode.valueOf(1));
		assertEquals(Opcode.MULTIPLY, Opcode.valueOf(2));
		assertEquals(Opcode.STOP, Opcode.valueOf(99));
	}

	@Test
	public void testValueOfError() {
		try {
			Opcode.valueOf(3);
			fail();
		} catch (RuntimeException e) {
			// ok
		}
	}

}

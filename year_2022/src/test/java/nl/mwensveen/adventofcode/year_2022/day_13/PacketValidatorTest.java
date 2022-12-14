package nl.mwensveen.adventofcode.year_2022.day_13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PacketValidatorTest {

	@Test
	public void testValidate1() {
		PacketPairs packet = new PacketPairs(1, "[1,1,3,1,1]", "[1,1,5,1,1]");
		PacketValidator validator = new PacketValidator();
		CompareResult validate = validator.validate(packet);
		assertEquals(CompareResult.OK, validate);
	}

	@Test
	public void testValidate2() {
		PacketPairs packet = new PacketPairs(2, "[[1],[2,3,4]]", "[[1],4]");
		PacketValidator validator = new PacketValidator();
		CompareResult validate = validator.validate(packet);
		assertEquals(CompareResult.OK, validate);
	}

	@Test
	public void testValidate3() {
		PacketPairs packet = new PacketPairs(3, "[9]", "[[8,7,6]]");
		PacketValidator validator = new PacketValidator();
		CompareResult validate = validator.validate(packet);
		assertEquals(CompareResult.WRONG, validate);
	}

	@Test
	public void testValidate4() {
		PacketPairs packet = new PacketPairs(4, "[[4,4],4,4]", "[[4,4],4,4,4]");
		PacketValidator validator = new PacketValidator();
		CompareResult validate = validator.validate(packet);
		assertEquals(CompareResult.OK, validate);
	}

	@Test
	public void testValidate5() {
		PacketPairs packet = new PacketPairs(5, "[7,7,7,7]", "[7,7,7]");
		PacketValidator validator = new PacketValidator();
		CompareResult validate = validator.validate(packet);
		assertEquals(CompareResult.WRONG, validate);
	}

	@Test
	public void testValidate6() {
		PacketPairs packet = new PacketPairs(6, "[]", "[3]");
		PacketValidator validator = new PacketValidator();
		CompareResult validate = validator.validate(packet);
		assertEquals(CompareResult.OK, validate);
	}

	@Test
	public void testValidate7() {
		PacketPairs packet = new PacketPairs(7, "[[[]]]", "[[]]");
		PacketValidator validator = new PacketValidator();
		CompareResult validate = validator.validate(packet);
		assertEquals(CompareResult.WRONG, validate);
	}

	@Test
	public void testValidate8() {
		PacketPairs packet = new PacketPairs(8, "[1,[2,[3,[4,[5,6,7]]]],8,9]", "[1,[2,[3,[4,[5,6,0]]]],8,9]");
		PacketValidator validator = new PacketValidator();
		CompareResult validate = validator.validate(packet);
		assertEquals(CompareResult.WRONG, validate);
	}

}

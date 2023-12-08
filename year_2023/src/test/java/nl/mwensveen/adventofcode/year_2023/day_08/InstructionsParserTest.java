package nl.mwensveen.adventofcode.year_2023.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class InstructionsParserTest {
	private String input = """
			RL

			AAA = (BBB, CCC)
			BBB = (DDD, EEE)
			CCC = (ZZZ, GGG)
			DDD = (DDD, DDD)
			EEE = (EEE, EEE)
			GGG = (GGG, GGG)
			ZZZ = (ZZZ, ZZZ)
						""";

	@Test
	public void testParse() {
		Instructions instructions = new InstructionsParser().parse(input.lines().toList());
		assertEquals(Arrays.asList("R", "L"), instructions.instruction());
		Map<String, LeftRight> nodes = instructions.nodes();
		assertEquals(7, nodes.size());
		LeftRight leftRight = nodes.get("AAA");
		assertEquals("BBB", leftRight.left());
		assertEquals("CCC", leftRight.right());
		leftRight = nodes.get("ZZZ");
		assertEquals("ZZZ", leftRight.left());
		assertEquals("ZZZ", leftRight.right());
	}

}

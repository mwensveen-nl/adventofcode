package nl.mwensveen.adventofcode.year_2023.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NetworkNavigatorTest {

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
	private String input2 = """
			LLR

			AAA = (BBB, BBB)
			BBB = (AAA, ZZZ)
			ZZZ = (ZZZ, ZZZ)
			""";

	private String input3 = """
			LR

			11A = (11B, XXX)
			11B = (XXX, 11Z)
			11Z = (11B, XXX)
			22A = (22B, XXX)
			22B = (22C, 22C)
			22C = (22Z, 22Z)
			22Z = (22B, 22B)
			XXX = (XXX, XXX)
						""";

	@Test
	public void testNavigate() {
		Instructions instructions = new InstructionsParser().parse(input.lines().toList());
		long count = new NetworkNavigator().navigate(instructions);
		assertEquals(2, count);

	}

	@Test
	public void testNavigate2() {
		Instructions instructions = new InstructionsParser().parse(input2.lines().toList());
		long count = new NetworkNavigator().navigate(instructions);
		assertEquals(6, count);

	}

	@Test
	public void testNavigateMultipleNodes() {
		Instructions instructions = new InstructionsParser().parse(input3.lines().toList());
		long count = new NetworkNavigator().navigateMultipleNodes(instructions);
		assertEquals(6, count);
	}

}

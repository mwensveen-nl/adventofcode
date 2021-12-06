package nl.mwensveen.adventofcode.year_2021.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LanternfishSimulatorTest {

	@Test
	public void testSimulate() {
		List<Integer> input = Arrays.asList(3, 4, 3, 1, 2);
		LanternfishSimulator simulator = new LanternfishSimulator();
		long result = simulator.simulate(input, 80);
		assertEquals(5934, result);
	}

	@Test
	public void testSimulate2() {
		List<Integer> input = Arrays.asList(3, 4, 3, 1, 2);
		LanternfishSimulator simulator = new LanternfishSimulator();
		long result = simulator.simulate(input, 256);
		assertEquals(26984457539L, result);
	}

}

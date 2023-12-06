package nl.mwensveen.adventofcode.year_2023.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RaceSimulatorTest {

	@Test
	public void testWinningRaces() {
		RaceSimulator raceSimulator = new RaceSimulator();
		assertEquals(4, raceSimulator.winningRaces(7, 9));
		assertEquals(8, raceSimulator.winningRaces(15, 40));
		assertEquals(9, raceSimulator.winningRaces(30, 200));
	}

	@Test
	public void testSimulateRaces() {
		List<Race> races = Arrays.asList(new Race(7, 9), new Race(15, 40), new Race(30, 200));
		long simulateRaces = new RaceSimulator().simulateRaces(races);
		assertEquals(288, simulateRaces);
	}

}

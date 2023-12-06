package nl.mwensveen.adventofcode.year_2023.day_06;

import java.util.Arrays;
import java.util.List;

import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;

public class WaitForItSolution extends AbstractTimedSolution {

	@Override
	protected void init() {

	}

	@Override
	protected void part1() {
		List<Race> input = Arrays.asList(new Race(41, 249), new Race(77, 1362), new Race(70, 1127), new Race(96, 1011));
		RaceSimulator raceSimulator = new RaceSimulator();
		long simulateRaces = raceSimulator.simulateRaces(input);
		System.out.println("Result when multiplying the number of ways you could beat the record in each race together " + simulateRaces);
	}

	@Override
	protected void part2() {
		List<Race> input = Arrays.asList(new Race(41777096, 249136211271011L));
		RaceSimulator raceSimulator = new RaceSimulator();
		long simulateRaces = raceSimulator.simulateRaces(input);
		System.out.println("Result when multiplying the number of ways you could beat the record in each race together " + simulateRaces);

	}

	public static void main(String[] args) {
		new WaitForItSolution().run();

	}

}

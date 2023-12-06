package nl.mwensveen.adventofcode.year_2023.day_06;

import java.util.List;

public class RaceSimulator {

	public long winningRaces(long raceTime, long record) {
		DistanceCalculator distanceCalculator = new DistanceCalculator();
		boolean win = true;
		long pressTime = raceTime / 2;
		while (win) {
			long distance = distanceCalculator.calculate(raceTime, pressTime);
			win = distance > record;
			pressTime--;
		}
		long smallestWin = pressTime + 2;
		long largestWin = raceTime - smallestWin;
		return largestWin - smallestWin + 1;
	}

	public long simulateRaces(List<Race> races) {
		return races.stream().map(r -> winningRaces(r.raceTime(), r.record())).reduce(1L, Math::multiplyExact);
	}
}

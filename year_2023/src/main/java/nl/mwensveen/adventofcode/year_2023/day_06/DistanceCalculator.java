package nl.mwensveen.adventofcode.year_2023.day_06;

public class DistanceCalculator {

	public long calculate(long raceTime, long pressTime) {
		return (raceTime - pressTime) * pressTime;
	}
}

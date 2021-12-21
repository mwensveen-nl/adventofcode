package nl.mwensveen.adventofcode.year_2021.day_21;

public class DeterministicDice {

	private int value = -1;

	public int next() {
		value++;
		return (value % 10) + 1;
	}

	public int timesThrown() {
		return value + 1;
	}
}

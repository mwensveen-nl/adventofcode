package nl.mwensveen.adventofcode.year_2023.day_05;

public record Range(Long start, long end, long range) {

	public Range(Long start, long range) {
		this(start, start + range - 1, range);
	}
}

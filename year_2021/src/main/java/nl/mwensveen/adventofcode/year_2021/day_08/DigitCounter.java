package nl.mwensveen.adventofcode.year_2021.day_08;

import java.util.Arrays;
import java.util.List;

import nl.mwensveen.adventofcode.year_2021.day_08.Digit.Builder;

public class DigitCounter {

	public long countKnownDigits(List<String> input) {
		return input.stream().flatMap(s -> toDigits(s).stream()).filter(d -> isKnowdDigit(d)).count();
	}

	private boolean isKnowdDigit(Digit d) {
		int count = d.count();
		return (count == Digit.ONE.count() || count == Digit.FOUR.count() || count == Digit.SEVEN.count()
				|| count == Digit.EIGHT.count());
	}

	private List<Digit> toDigits(String s) {
		String[] split = s.split("\\|");
		String[] digitInput = split[1].trim().split(" ");
		return Arrays.stream(digitInput).map(s2 -> toDigit(s2)).toList();
	}

	private Digit toDigit(String s) {
		Builder builder = Digit.builder();
		s.codePoints().forEach(cp -> builder.with(cp));
		return builder.build();
	}
}

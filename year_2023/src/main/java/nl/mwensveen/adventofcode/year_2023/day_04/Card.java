package nl.mwensveen.adventofcode.year_2023.day_04;

import java.util.Arrays;
import java.util.List;

public record Card(Integer cardNumber, List<Integer> winningNumbers, List<Integer> yourNumbers) {

	public static Card parse(String line) {
		String number = line.substring(4, line.indexOf(":")).trim();
		String winning = line.substring(line.indexOf(":") + 1, line.indexOf("|")).trim();
		String yours = line.substring(line.indexOf("|") + 1).trim();

		return new Card(Integer.valueOf(number), parseNumbers(winning), parseNumbers(yours));
	}

	private static List<Integer> parseNumbers(String numbers) {
		return Arrays.stream(numbers.split(" ")).filter(s -> !s.isBlank()).map(s -> Integer.valueOf(s)).toList();
	}

	public Long numberOfMatches() {
		return yourNumbers.stream().filter(yn -> winningNumbers().contains(yn)).count();
	}

}

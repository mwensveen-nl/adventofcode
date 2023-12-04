package nl.mwensveen.adventofcode.year_2023.day_04;

import java.util.List;

public class Cardparser {

	public List<Card> parse(List<String> input) {
		return input.stream().map(Card::parse).toList();
	}
}

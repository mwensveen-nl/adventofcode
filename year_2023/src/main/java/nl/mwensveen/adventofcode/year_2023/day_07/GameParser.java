package nl.mwensveen.adventofcode.year_2023.day_07;

import java.util.List;

public class GameParser {

	public List<HandBid> parse(List<String> input) {
		return input.stream().map(HandBid::parse).toList();
	}

	public List<HandBid> parseWithJokers(List<String> input) {
		return input.stream().map(HandBid::parseWithJokers).toList();
	}
}

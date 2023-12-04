package nl.mwensveen.adventofcode.year_2023.day_04;

import java.util.List;

public class CardWithCopiesParser {

	public List<CardWithCopies> parse(List<Card> cards) {
		return cards.stream().map(CardWithCopies::create).toList();
	}
}

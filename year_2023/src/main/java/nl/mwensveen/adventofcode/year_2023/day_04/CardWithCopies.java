package nl.mwensveen.adventofcode.year_2023.day_04;

import java.util.List;
import java.util.stream.LongStream;

public record CardWithCopies(Card card, List<Integer> copies) {

	public static CardWithCopies create(Card card) {
		long numberOfMatches = card.numberOfMatches();
		List<Integer> list = LongStream.rangeClosed(card.cardNumber() + 1, card.cardNumber() + numberOfMatches).mapToInt(l -> (int) l)
				.mapToObj(Integer::valueOf).toList();
		return new CardWithCopies(card, list);
	}
}

package nl.mwensveen.adventofcode.year_2023.day_04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CardsWinningCalculator {

	public Long winnings(List<Card> cards) {
		return cards.stream().map(this::winnings).collect(Collectors.summingLong(l -> l));
	}

	private Long winnings(Card card) {
		return (long) Math.pow(2, card.numberOfMatches() - 1);
	}

	public long scratchcardsWinnings(List<Card> cards) {
		List<CardWithCopies> cwcs = new CardWithCopiesParser().parse(cards);
		Map<Integer, AtomicInteger> cardCount = new HashMap<>();
		IntStream.rangeClosed(1, cwcs.size()).forEach(i -> cardCount.put(i, new AtomicInteger(1)));

		cwcs.stream().forEach(cwc -> {
			cwc.copies().stream().forEach(i -> cardCount.get(i).addAndGet(cardCount.get(cwc.card().cardNumber()).get()));
		});

		return cardCount.values().stream().map(i -> i.get()).collect(Collectors.summingInt(i -> i));
	}
}

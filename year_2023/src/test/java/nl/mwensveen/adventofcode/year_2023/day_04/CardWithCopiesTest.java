package nl.mwensveen.adventofcode.year_2023.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CardWithCopiesTest {

	@Test
	public void testCreate() {
		String input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
		Card card = Card.parse(input);

		CardWithCopies cardWithCopies = CardWithCopies.create(card);
		assertEquals(card, cardWithCopies.card());
		assertEquals(List.of(2, 3, 4, 5), cardWithCopies.copies());
	}

}

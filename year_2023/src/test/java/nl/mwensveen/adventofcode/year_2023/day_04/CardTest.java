package nl.mwensveen.adventofcode.year_2023.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CardTest {

	@Test
	public void testParse() {
		String input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
		Card card = Card.parse(input);
		assertEquals(List.of(41, 48, 83, 86, 17), card.winningNumbers());
		assertEquals(List.of(83, 86, 6, 31, 17, 9, 48, 53), card.yourNumbers());
		assertEquals(4, card.numberOfMatches());
	}

}

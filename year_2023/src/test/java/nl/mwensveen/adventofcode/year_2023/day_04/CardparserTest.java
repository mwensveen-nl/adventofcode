package nl.mwensveen.adventofcode.year_2023.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CardparserTest {

	private String input = """
			Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
			Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
			Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
			Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
			Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
			Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
															""";

	@Test
	public void testParse() {
		List<Card> cards = new Cardparser().parse(input.lines().toList());
		assertEquals(6, cards.size());

		assertTrue(cards.get(0).winningNumbers().contains(41));
		assertTrue(cards.get(0).winningNumbers().contains(17));
		assertTrue(cards.get(0).yourNumbers().contains(83));
		assertTrue(cards.get(0).yourNumbers().contains(53));

		assertTrue(cards.get(5).winningNumbers().contains(31));
		assertTrue(cards.get(5).winningNumbers().contains(72));
		assertTrue(cards.get(5).yourNumbers().contains(74));
		assertTrue(cards.get(5).yourNumbers().contains(11));
	}

}
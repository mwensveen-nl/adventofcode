package nl.mwensveen.adventofcode.year_2023.day_07;

import java.util.Arrays;
import java.util.List;

public class CardStrength {
	// 0 is for the Joker
	public static List<String> cards = Arrays.asList("A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2", "0");

	public static int getStrength(String card) {
		return cards.size() - cards.indexOf(card);
	}

}

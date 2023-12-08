package nl.mwensveen.adventofcode.year_2023.day_07;

import java.util.List;

public record Hand(List<String> cards, Type type) {

	public static Hand parse(String input) {
		List<String> list = input.chars().mapToObj(Character::toString).toList();
		return new Hand(list, Type.determine(list));
	}

	public static Hand parseWithJokers(String input) {
		List<String> list = input.chars().mapToObj(Character::toString).toList();

		return new Hand(list.stream().map(s -> s.equals("J") ? "0" : s).toList(), Type.determineWithJoker(list));
	}

	public static int compare(Hand h1, Hand h2) {
		if (h1.type.getStrength() != h2.type.getStrength()) {
			return h1.type.getStrength() - h2.type.getStrength();
		}
		for (int i = 0; i < 5; i++) {
			if (CardStrength.getStrength(h1.cards.get(i)) != CardStrength.getStrength(h2.cards.get(i))) {
				return CardStrength.getStrength(h1.cards.get(i)) - CardStrength.getStrength(h2.cards.get(i));
			}
		}
		return 0;
	}
}

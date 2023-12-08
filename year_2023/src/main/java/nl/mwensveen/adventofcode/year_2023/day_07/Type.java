package nl.mwensveen.adventofcode.year_2023.day_07;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public enum Type {
	FiveOfAKind(7),
	FourOfAKind(6),
	FullHouse(5),
	ThreeOfAKind(4),
	TwoPair(3),
	OnePair(2),
	HighCard(1);

	private int strength;

	Type(int strength) {
		this.strength = strength;
	}

	public int getStrength() {
		return strength;
	}

	public static Type determine(List<String> hand) {
		Map<String, List<String>> group = hand.stream().collect(Collectors.groupingBy(s -> s));
		int size = group.size();
		if (size == 1) {
			return FiveOfAKind;
		}
		if (size == 2) {
			int maxGroup = group.values().stream().mapToInt(v -> v.size()).max().getAsInt();
			if (maxGroup == 4) {
				return FourOfAKind;
			}
			return FullHouse;
		}
		if (size == 3) {
			int maxGroup = group.values().stream().mapToInt(v -> v.size()).max().getAsInt();
			if (maxGroup == 3) {
				return ThreeOfAKind;
			}
			return TwoPair;
		}
		if (size == 4) {
			return OnePair;
		}
		return HighCard;
	}

	public static Type determineWithJoker(List<String> hand) {
		List<String> noJokers = hand.stream().filter(s -> !s.equals("J")).toList();
		if (noJokers.size() == 0) {
			return FiveOfAKind;
		}

		Map<String, List<String>> groups = noJokers.stream().collect(Collectors.groupingBy(s -> s));
		Entry<String, List<String>> entry = groups.entrySet().stream().sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size()).findFirst().get();

		List<String> handNoJokers = hand.stream().map(s -> s.equals("J") ? entry.getKey() : s).toList();
		return determine(handNoJokers);

	}
}

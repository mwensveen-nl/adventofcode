package nl.mwensveen.adventofcode.year_2021.day_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NavigationSubsystemAnalyser {

	public Integer findCorruptScore(List<String> input) {
		return input.stream().map(l -> findCorruptPoints(l)).filter(oi -> oi.isPresent()).collect(Collectors.summingInt(oi -> oi.get()));
	}

	public Long findIncompleteScore(List<String> input) {
		List<Long> scores = input.stream().map(l -> findIncompleteLines(l)).filter(oi -> oi.isPresent()).map(oi -> oi.get()).sorted().toList();
		int i = (scores.size() / 2);
		return scores.get(i);
	}

	private Optional<Long> findIncompleteLines(String l) {
		List<Symbol> sb = new ArrayList<>();
		List<Character> symbols = stringAsList(l);
		Optional<Symbol> corruptSymbol = symbols.stream().map(c -> Symbol.find(c)).filter(s -> isCorrupt(s, sb)).findFirst();
		if (corruptSymbol.isPresent()) {
			return Optional.empty();
		}
		if (sb.size() == 0) {
			return Optional.empty();
		}
		long score = 0;
		for (int i = sb.size() - 1; i >= 0; i--) {
			score = (score * 5) + sb.get(i).getValue();

		}
		return Optional.of(score);
	}

	private Optional<Integer> findCorruptPoints(String l) {
		List<Symbol> sb = new ArrayList<>();
		List<Character> symbols = stringAsList(l);
		Optional<Symbol> corruptSymbol = symbols.stream().map(c -> Symbol.find(c)).filter(s -> isCorrupt(s, sb)).findFirst();
		if (corruptSymbol.isPresent()) {
			return Optional.of(corruptSymbol.get().getValue());
		}
		return Optional.empty();
	}

	private boolean isCorrupt(Symbol symbol, List<Symbol> sb) {
		if (symbol.isOpen()) {
			sb.add(symbol);
			return false;
		}

		if (sb.size() == 0) {
			return true;
		}
		Symbol openSymbol = sb.get(sb.size() - 1);
		if (symbol.getOpenSymbol().equals(openSymbol)) {
			sb.remove(sb.size() - 1);
			return false;
		}
		return true;
	}

	private List<Character> stringAsList(String signal) {
		return signal.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
	}
}

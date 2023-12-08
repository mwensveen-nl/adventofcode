package nl.mwensveen.adventofcode.year_2023.day_08;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InstructionsParser {

	public Instructions parse(List<String> input) {
		List<String> instr = input.get(0).codePoints().mapToObj(Character::toString).toList();
		Map<String, LeftRight> lrs = parseLR(input.stream().skip(2));
		return new Instructions(instr, lrs);
	}

	private Map<String, LeftRight> parseLR(Stream<String> input) {
		return input.collect(Collectors.toMap(this::getKey, this::getLeftRight));
	}

	private String getKey(String s) {
		return s.substring(0, 3);
	}

	private LeftRight getLeftRight(String s) {
		return new LeftRight(s.substring(7, 10), s.substring(12, 15));
	}
}

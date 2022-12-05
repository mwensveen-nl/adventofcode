package nl.mwensveen.adventofcode.year_2022.day_05;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class MoveCratesProcessor {
	private final Pattern PATTERN = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)", Pattern.CASE_INSENSITIVE);

	public void processInstructions(List<String> lines, Map<Integer, Stack<String>> stacks) {
		lines.stream().forEach(l -> moveCrates(l, stacks));
	}

	public void moveCrates(String instruction, Map<Integer, Stack<String>> stacks) {
		Matcher matcher = PATTERN.matcher(instruction);
		matcher.matches();
		// group 0 = the whole match
		int number = Integer.parseInt(matcher.group(1));
		int from = Integer.parseInt(matcher.group(2));
		int to = Integer.parseInt(matcher.group(3));

		IntStream.range(0, number).forEach(i -> stacks.get(to).push(stacks.get(from).pop()));
	}
}

package nl.mwensveen.adventofcode.year_2021.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class NavigationSubsystemAnalyserTest {

	@Test
	public void testFindCorruptScore() {
		List<String> input = Arrays.asList("[({(<(())[]>[[{[]{<()<>>",
				"[(()[<>])]({[<{<<[]>>(",
				"{([(<{}[<>[]}>{[]{[(<()>",
				"(((({<>}<{<{<>}{[]{[]{}",
				"[[<[([]))<([[{}[[()]]]",
				"[{[{({}]{}}([{[{{{}}([]",
				"{<[[]]>}<{[{[{[]{()[[[]",
				"[<(<(<(<{}))><([]([]()",
				"<{([([[(<>()){}]>(<<{{",
				"<{([{{}}[<[[[<>{}]]]>[]]");
		NavigationSubsystemAnalyser analyser = new NavigationSubsystemAnalyser();
		Integer result = analyser.findCorruptScore(input);
		assertEquals(26397, result);
	}

	@Test
	public void testFindIncompleteLines() {
		List<String> input = Arrays.asList("[({(<(())[]>[[{[]{<()<>>",
				"[(()[<>])]({[<{<<[]>>(",
				"{([(<{}[<>[]}>{[]{[(<()>",
				"(((({<>}<{<{<>}{[]{[]{}",
				"[[<[([]))<([[{}[[()]]]",
				"[{[{({}]{}}([{[{{{}}([]",
				"{<[[]]>}<{[{[{[]{()[[[]",
				"[<(<(<(<{}))><([]([]()",
				"<{([([[(<>()){}]>(<<{{",
				"<{([{{}}[<[[[<>{}]]]>[]]");
		NavigationSubsystemAnalyser analyser = new NavigationSubsystemAnalyser();
		Long result = analyser.findIncompleteScore(input);
		assertEquals(288957L, result);
	}

}

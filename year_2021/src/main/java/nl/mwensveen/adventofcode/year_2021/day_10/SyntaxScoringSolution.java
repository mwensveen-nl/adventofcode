package nl.mwensveen.adventofcode.year_2021.day_10;

import java.util.List;

import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class SyntaxScoringSolution extends AbstractTimedSolution {

	private List<String> input;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("day_10.txt");
	}

	@Override
	protected void part1() {
		NavigationSubsystemAnalyser analyser = new NavigationSubsystemAnalyser();
		Integer result = analyser.findCorruptScore(input);
		System.out.println("total syntax error score for corruption errors: " + result);
	}

	@Override
	protected void part2() {
		NavigationSubsystemAnalyser analyser = new NavigationSubsystemAnalyser();
		Long result = analyser.findIncompleteScore(input);
		System.out.println("total completion score for incomplete lines: " + result);
	}

	public static void main(String[] args) {
		new SyntaxScoringSolution().run();
	}

}

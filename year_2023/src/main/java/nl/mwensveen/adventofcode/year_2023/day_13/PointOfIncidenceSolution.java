package nl.mwensveen.adventofcode.year_2023.day_13;

import java.util.List;

import com.google.common.collect.Table;

import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class PointOfIncidenceSolution extends AbstractTimedSolution {

	private List<String> input;
	private List<Table<Integer, Integer, Symbol>> list;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("Day_13.txt");
		PatternParser parser = new PatternParser();
		list = parser.parse(input);
	}

	@Override
	protected void part1() {
		PatternAnalyzer patternAnalyzer = new PatternAnalyzer();
		long result = patternAnalyzer.analyze(list);
		System.out.println("the number after summarizing all of the notes: " + result);

	}

	@Override
	protected void part2() {
		PatternAnalyzer patternAnalyzer = new PatternAnalyzer();
		long result = patternAnalyzer.analyzeWithSmudge(list);
		System.out.println("the number after summarizing all of the new notes: " + result);
	}

	public static void main(String[] args) {
		new PointOfIncidenceSolution().run();
	}

}

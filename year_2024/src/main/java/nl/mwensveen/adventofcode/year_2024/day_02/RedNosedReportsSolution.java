package nl.mwensveen.adventofcode.year_2024.day_02;

import java.util.List;

import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class RedNosedReportsSolution extends AbstractTimedSolution {

	private List<String> input;
	private ReportParser reportParser = new ReportParser();
	private ReportAnalyzer reportAnalyzer = new ReportAnalyzer();
	private List<List<Integer>> reports;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("Day_02.txt");
		reports = reportParser.parseReports(input);
	}

	@Override
	protected void part1() {
		long analyzeReports = reportAnalyzer.analyzeReports(reports);
		System.out.println("Numbert of reports that are safe: " + analyzeReports);
	}

	@Override
	protected void part2() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new RedNosedReportsSolution().run();
	}

}

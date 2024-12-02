package nl.mwensveen.adventofcode.year_2024.day_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class ReportAnalyzerTest {
	private String input = """
			7 6 4 2 1
			1 2 7 8 9
			9 7 6 2 1
			1 3 2 4 5
			8 6 4 4 1
			1 3 6 7 9
					""";

	@Test
	public void testAnalyzeReports() {
		ReportParser parser = new ReportParser();
		List<List<Integer>> reports = parser.parseReports(input.lines().toList());

		ReportAnalyzer reportAnalyzer = new ReportAnalyzer();
		long result = reportAnalyzer.analyzeReports(reports);
		assertEquals(2, result);
	}

}

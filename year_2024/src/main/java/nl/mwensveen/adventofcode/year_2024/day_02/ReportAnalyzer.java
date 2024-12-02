package nl.mwensveen.adventofcode.year_2024.day_02;

import java.util.List;

public class ReportAnalyzer {

	public long analyzeReports(List<List<Integer>> reports) {
		return reports.stream().filter(this::valid).count();
	}

	private boolean valid(List<Integer> r) {
		boolean increase = r.get(0) < r.get(1);
		for (int i = 0; i < r.size() - 1; i++) {
			int level1 = r.get(i);
			int level2 = r.get(i + 1);
			if (increase && level1 >= level2) {
				return false;
			}
			if (!increase && level1 <= level2) {
				return false;
			}
			if (Math.abs(level1 - level2) > 3) {
				return false;
			}

		}
		return true;
	}

}

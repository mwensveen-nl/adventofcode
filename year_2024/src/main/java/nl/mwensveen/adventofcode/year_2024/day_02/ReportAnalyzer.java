package nl.mwensveen.adventofcode.year_2024.day_02;

import java.util.ArrayList;
import java.util.List;

public class ReportAnalyzer {

	public long analyzeReports(List<List<Integer>> reports) {
		return reports.stream().filter(this::valid).count();
	}

	public long analyzeReportsWithDampener(List<List<Integer>> reports) {
		return reports.stream().filter(this::validWithDampener).count();
	}

	private boolean valid(List<Integer> r) {
		return findInvalid(r) == null;
	}

	private Integer findInvalid(List<Integer> r) {
		boolean increase = r.get(0) < r.get(1);
		for (int i = 0; i < r.size() - 1; i++) {
			int level1 = r.get(i);
			int level2 = r.get(i + 1);
			if (increase && level1 >= level2) {
				return i;
			}
			if (!increase && level1 <= level2) {
				return i;
			}
			if (Math.abs(level1 - level2) > 3) {
				return i;
			}

		}
		return null;
	}

	private boolean validWithDampener(List<Integer> r) {
		Integer invalid = findInvalid(r);
		if (invalid == null) {
			return true;
		}

		List<Integer> newReport = new ArrayList<>(r);
		newReport.remove(invalid.intValue());
		Integer newInvalid = findInvalid(newReport);
		if (newInvalid == null) {
			return true;
		}

		newReport = new ArrayList<>(r);
		newReport.remove(invalid.intValue() + 1);
		newInvalid = findInvalid(newReport);
		if (newInvalid == null) {
			return true;
		}

		if (invalid > 0) {
			newReport = new ArrayList<>(r);
			newReport.remove(invalid.intValue() - 1);
			newInvalid = findInvalid(newReport);
			if (newInvalid == null) {
				return true;
			}
		}
		return false;
	}

}

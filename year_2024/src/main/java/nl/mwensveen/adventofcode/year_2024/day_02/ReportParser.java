package nl.mwensveen.adventofcode.year_2024.day_02;

import java.util.ArrayList;
import java.util.List;

public class ReportParser {

	public List<List<Integer>> parseReports(List<String> input) {
		List<List<Integer>> result = new ArrayList<>();

		input.forEach(line -> {
			String[] split = line.trim().split(" ");
			List<Integer> report = new ArrayList<>();
			for (String s : split) {
				report.add(Integer.valueOf(s));
			}
			result.add(report);
		});
		return result;
	}
}

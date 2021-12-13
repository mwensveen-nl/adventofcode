package nl.mwensveen.adventofcode.year_2021.day_13;

import java.util.List;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TransparentPaperParser {

	Table<Integer, Integer, Character> parsePaper(List<String> input) {
		Table<Integer, Integer, Character> paper = HashBasedTable.create();

		input.stream().takeWhile(row -> !row.isBlank()).forEach(dot -> putOnPaper(dot, paper));

		return paper;
	}

	List<String> parseInstructions(List<String> input) {

	}

	private void putOnPaper(String dot, Table<Integer, Integer, Character> paper) {
		String[] split = dot.split(",");
		paper.put(Integer.parseInt(split[1]), Integer.parseInt(split[0]), '#');
	}

}

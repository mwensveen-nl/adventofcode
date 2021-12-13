package nl.mwensveen.adventofcode.year_2021.day_13;

import java.util.List;

import com.google.common.collect.Table;

public class TransparentPaperFolderProcessor {

	void procesPaper(List<String> input) {
		TransparentPaperParser transparentPaperParser = new TransparentPaperParser();
		Table<Integer, Integer, Character> paper = transparentPaperParser.parsePaper(input);

	}
}

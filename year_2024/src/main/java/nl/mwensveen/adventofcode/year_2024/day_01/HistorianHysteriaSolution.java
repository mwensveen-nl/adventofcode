package nl.mwensveen.adventofcode.year_2024.day_01;

import java.util.List;

import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class HistorianHysteriaSolution extends AbstractTimedSolution {

	private List<String> input;
	private List<List<Integer>> lists;
	private LocationListComparator locationListComparator = new LocationListComparator();

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("Day_01.txt");
		LocationListParser locationListParser = new LocationListParser();
		lists = locationListParser.readLists(input);
	}

	@Override
	protected void part1() {
		Integer result = locationListComparator.compareLists(lists.getFirst(), lists.getLast());
		System.out.println("The total distance between the two lists: " + result);
	}

	@Override
	protected void part2() {
		Integer result = locationListComparator.similarityScore(lists.getFirst(), lists.getLast());
		System.out.println("The similarity score: " + result);
	}

	public static void main(String[] args) {
		new HistorianHysteriaSolution().run();
	}

}

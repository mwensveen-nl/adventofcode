package nl.mwensveen.adventofcode.year_2023.day_11;

import java.util.List;

import com.google.common.collect.Table;

import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class CosmicExpansionSolution extends AbstractTimedSolution {

	private List<String> input;
	private Table<Integer, Integer, String> galaxies;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("Day_11.txt");
		galaxies = new GalaxiesParser().parseGalaxies(input);
	}

	@Override
	protected void part1() {
		long distance = new DistanceCalculator(2).calculate(galaxies);
		System.out.println("Sum of the length of the shortest path between every pair of galaxies: " + distance);
	}

	@Override
	protected void part2() {
		long distance = new DistanceCalculator(1000000).calculate(galaxies);
		System.out.println("Sum of the length of the shortest path between every pair of galaxies: " + distance);
	}

	public static void main(String[] args) {
		new CosmicExpansionSolution().run();
	}

}

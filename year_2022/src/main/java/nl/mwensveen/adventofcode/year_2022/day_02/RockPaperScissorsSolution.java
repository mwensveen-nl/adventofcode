package nl.mwensveen.adventofcode.year_2022.day_02;

import java.util.List;

import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class RockPaperScissorsSolution extends AbstractTimedSolution {

	private List<String> input;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("day02.txt");
	}

	@Override
	protected void part1() {
		RockPaperScissorsCalculator calculator = new RockPaperScissorsCalculator();
		int score = calculator.playTournament(input);
		System.out.println("Total score if everything goes exactly according to your strategy guide: " + score);

	}

	@Override
	protected void part2() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new RockPaperScissorsSolution().run();
	}

}

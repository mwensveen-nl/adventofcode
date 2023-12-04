package nl.mwensveen.adventofcode.year_2023.day_04;

import java.util.List;

import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class ScratchcardsSolution extends AbstractTimedSolution {

	private List<Card> cards;

	@Override
	protected void init() {
		List<String> input = FileReadHelper.readLinesAsStrings("Day_04.txt");
		cards = new Cardparser().parse(input);
	}

	@Override
	protected void part1() {
		CardsWinningCalculator calculator = new CardsWinningCalculator();
		Long winnings = calculator.winnings(cards);
		System.out.println("The points the Elf's pile of scratchcards are worth in total: " + winnings);

	}

	@Override
	protected void part2() {
		CardsWinningCalculator calculator = new CardsWinningCalculator();
		Long winnings = calculator.scratchcardsWinnings(cards);
		System.out.println("total scratchcards do we end up with: " + winnings);
	}

	public static void main(String[] args) {
		new ScratchcardsSolution().run();

	}

}

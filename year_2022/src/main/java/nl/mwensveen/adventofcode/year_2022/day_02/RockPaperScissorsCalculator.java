package nl.mwensveen.adventofcode.year_2022.day_02;

import java.util.List;

public class RockPaperScissorsCalculator {

	public int playTournament(List<String> input) {
		return input.stream().mapToInt(round -> calculateRound(Shape.findOppponent(round.substring(0, 1)),
				Shape.findSelf(round.substring(2, 3)))).sum();
	}

	public int calculateRound(Shape opponent, Shape self) {
		return self.getScore() + self.wins(opponent);
	}
}

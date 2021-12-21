package nl.mwensveen.adventofcode.year_2021.day_21;

import java.util.List;

import org.javatuples.Pair;

public class Game {

	public long playGame(List<String> input) {
		GameBoardParser gameBoardParser = new GameBoardParser();
		Pair<Player, Player> players = gameBoardParser.parseGameBoard(input);

		DeterministicDice dice = new DeterministicDice();

		int player = 0;
		while (players.getValue0().getScore() < 1000 && players.getValue1().getScore() < 1000) {
			int move = diceThree(dice);

			if (player == 0) {
				players.getValue0().move(move);
				player = 1;
			} else {
				players.getValue1().move(move);
				player = 0;
			}
		}

		long loserScore = Math.min(players.getValue0().getScore(), players.getValue1().getScore());
		return loserScore * dice.timesThrown();
	}

	private int diceThree(DeterministicDice dice) {
		return dice.next() + dice.next() + dice.next();
	}
}

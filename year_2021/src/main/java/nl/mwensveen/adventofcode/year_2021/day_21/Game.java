package nl.mwensveen.adventofcode.year_2021.day_21;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.javatuples.Pair;

public class Game {

	public long playGame(List<String> input, int winningScore) {
		GameBoardParser gameBoardParser = new GameBoardParser();
		Pair<Player, Player> players = gameBoardParser.parseGameBoard(input);

		DeterministicDice dice = new DeterministicDice();

		int player = 0;
		while (players.getValue0().getScore() < winningScore && players.getValue1().getScore() < winningScore) {
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

	public long playGameQuantum(List<String> input, int winningScore) {
		GameBoardParser gameBoardParser = new GameBoardParser();
		Pair<Player, Player> players = gameBoardParser.parseGameBoard(input);

		Map<Integer, AtomicLong> wins = new HashMap<>();
		int winner = performMove(1, players.getValue0(), players.getValue1(), winningScore, wins);
		long loserScore = Math.min(players.getValue0().getScore(), players.getValue1().getScore());
		return loserScore * dice.timesThrown();
	}

	private void performMove(int player, Player one, Player two, int winningScore, Map<Integer, AtomicLong> wins, int move) {
		if (player == 1) {
			one.move(move);
			if (one.getScore() >= winningScore) {
				wins.get(1).incrementAndGet();
				return;
			}
		} else {
			two.move(move);
			if (two.getScore() >= winningScore) {
				wins.get(2).incrementAndGet();
				return;
			}
		}
		performMove(player, one, two, winningScore, wins, move);
	}

	private int diceThree(DeterministicDice dice) {
		return dice.next() + dice.next() + dice.next();
	}
}

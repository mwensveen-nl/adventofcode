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

        Map<String, AtomicLong> wins = new HashMap<>();
        Player one = players.getValue0();
        wins.put(one.getName(), new AtomicLong());
        Player two = players.getValue1();
        wins.put(two.getName(), new AtomicLong());
        nextMoves(two.getPosition(), two.getName(), 0, one.getPosition(), one.getName(), 0, winningScore, wins, 1);
        return Math.max(wins.get(one.getName()).longValue(), wins.get(two.getName()).longValue());
    }

    private void performMove(int currentPos, String currentName, int currentScore, int otherPos, String otherName, int otherScore, int winningScore, Map<String, AtomicLong> wins,
            int move, long universes) {
        currentPos += move;
        currentPos = (currentPos - 1) % 10 + 1;
        currentScore += currentPos;
        if (currentScore >= winningScore) {
            wins.get(currentName).addAndGet(universes);
            return;
        }
        // next moves
        nextMoves(currentPos, currentName, currentScore, otherPos, otherName, otherScore, winningScore, wins, universes);

    }

    private void nextMoves(int currentPos, String currentName, int currentScore, int otherPos, String otherName, int otherScore, int winningScore, Map<String, AtomicLong> wins,
            long universes) {
        performMove(otherPos, otherName, otherScore, currentPos, currentName, currentScore, winningScore, wins, 3, universes * 1);
        performMove(otherPos, otherName, otherScore, currentPos, currentName, currentScore, winningScore, wins, 4, universes * 3);
        performMove(otherPos, otherName, otherScore, currentPos, currentName, currentScore, winningScore, wins, 5, universes * 6);
        performMove(otherPos, otherName, otherScore, currentPos, currentName, currentScore, winningScore, wins, 6, universes * 7);
        performMove(otherPos, otherName, otherScore, currentPos, currentName, currentScore, winningScore, wins, 7, universes * 6);
        performMove(otherPos, otherName, otherScore, currentPos, currentName, currentScore, winningScore, wins, 8, universes * 3);
        performMove(otherPos, otherName, otherScore, currentPos, currentName, currentScore, winningScore, wins, 9, universes * 1);
    }

    private int diceThree(DeterministicDice dice) {
        return dice.next() + dice.next() + dice.next();
    }
}

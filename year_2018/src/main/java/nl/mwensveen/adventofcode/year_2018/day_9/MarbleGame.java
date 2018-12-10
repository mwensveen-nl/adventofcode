package nl.mwensveen.adventofcode.year_2018.day_9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class MarbleGame {
    private int numberPlayers;
    private int lastMarbleNumber;

    public MarbleGame(int numberPlayers, int lastMarbleNumber) {
        this.numberPlayers = numberPlayers;
        this.lastMarbleNumber = lastMarbleNumber;
    }

    public Integer PlayGame() {
        List<Integer> players = new LinkedList<>();
        for (int i = 0; i <= numberPlayers; i++) {
            players.add(Integer.valueOf(0));
        }

        List<Integer> game = new ArrayList<>();
        int currentPosition = 0;
        int player = 0;

        for (int i = 0; i <= lastMarbleNumber; i++) {
            player++;
            if (player > numberPlayers) {
                player = 1;
            }
            if (game.size() == 0) {
                game.add(0, Integer.valueOf(i));
            } else if (game.size() == 1) {
                game.add(1, Integer.valueOf(i));
                currentPosition = 1;
            } else if (i % 23 == 0) {
                int newPosition = currentPosition - 7;
                if (newPosition < 0) {
                    newPosition = game.size() + newPosition;
                }
                Integer removed = game.remove(newPosition);
                currentPosition = newPosition;
                Integer score = players.get(player);
                int newScore = score.intValue() + i + removed.intValue();
                players.set(player, Integer.valueOf(newScore));
            } else {
                int newPosition = currentPosition + 2;
                if (newPosition > game.size()) {
                    newPosition = newPosition % game.size();
                }
                game.add(newPosition, Integer.valueOf(i));
                currentPosition = newPosition;
            }
        }
        Optional<Integer> max = players.stream().max(Comparator.naturalOrder());
        return max.get();
    }

    public Long calculateGame() {

        List<AtomicLong> players = new LinkedList<>();
        for (int i = 0; i <= numberPlayers; i++) {
            players.add(new AtomicLong(0));
        }
        Circle game = new Circle(0);

        for (int i = 1; i <= lastMarbleNumber; i++) {
            if (i % 23 == 0) {
                long removed = game.remove();
                players.get(i % numberPlayers).addAndGet(i + removed);
            } else {
                game.add(Integer.valueOf(i));
            }
        }
        Optional<Long> max = players.stream().map(AtomicLong::get).max(Comparator.naturalOrder());
        return max.get();

    }
}
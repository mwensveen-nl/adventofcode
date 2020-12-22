package nl.mwensveen.adventofcode.year_2020.day_22;

import java.util.List;

public class CombatGame {

    public Player playGame(List<Player> players) {

        Player player1 = players.get(0);
        Player player2 = players.get(1);

        while (player1.hasSpaceCards() && player2.hasSpaceCards()) {
            Integer card1 = player1.getTopSpaceCard();
            Integer card2 = player2.getTopSpaceCard();
            if (card1.compareTo(card2) > 0) {
                player1.addSpaceCards(card1, card2);
            } else {
                player2.addSpaceCards(card2, card1);
            }
        }
        Player winner;
        if (player1.hasSpaceCards()) {
            winner = player1;
        } else {
            winner = player2;
        }
        return winner;
    }
}

package nl.mwensveen.adventofcode.year_2020.day_22;

import java.util.ArrayList;
import java.util.List;

public class RecursiveCombatGame {

    public Player playGame(List<Player> players) {
        return playGame(players.get(0), players.get(1));
    }

    private Player playGame(Player player1, Player player2) {
        List<List<Integer>> player1Decks = new ArrayList<>();
        List<List<Integer>> player2Decks = new ArrayList<>();

        while (player1.hasSpaceCards() && player2.hasSpaceCards()) {
            if (player1Decks.contains(player1.getSpaceCard()) && player2Decks.contains(player2.getSpaceCard())) {
                return player1;
            }

            player1Decks.add(player1.copyDeck(player1.numberOfSpaceCards()));
            player2Decks.add(player2.copyDeck(player2.numberOfSpaceCards()));

            Integer card1 = player1.getTopSpaceCard();
            Integer card2 = player2.getTopSpaceCard();

            if (player1.numberOfSpaceCards() >= card1.intValue() && player2.numberOfSpaceCards() >= card2.intValue()) {
                // winner = subgame
                Player newPlayer1 = Player.builder().withName(player1.getName()).withSpaceCards(player1.copyDeck(card1.intValue())).build();
                Player newPlayer2 = Player.builder().withName(player2.getName()).withSpaceCards(player2.copyDeck(card2.intValue())).build();
                Player subGameWinner = playGame(newPlayer1, newPlayer2);
                if (subGameWinner.getName().equals(player1.getName())) {
                    player1.addSpaceCards(card1, card2);
                } else {
                    player2.addSpaceCards(card2, card1);
                }
            } else {
                if (card1.compareTo(card2) > 0) {
                    player1.addSpaceCards(card1, card2);
                } else {
                    player2.addSpaceCards(card2, card1);
                }
            }
        }
        if (player1.hasSpaceCards()) {
            return player1;
        } else {
            return player2;
        }
    }
}

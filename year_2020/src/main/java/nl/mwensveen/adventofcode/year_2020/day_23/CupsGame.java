package nl.mwensveen.adventofcode.year_2020.day_23;

import java.util.ArrayList;
import java.util.List;

public class CupsGame {

    public String playGame(List<Integer> input, int nrOfMoves) {
        Cups cups = new Cups(input);

        for (int i = 0; i < nrOfMoves; i++) {
            cups.doPickUp();
            cups.dropPickup();
            cups.pickNewCurrent();
        }
        return cups.finishedLabels();
    }

    public long playGameMillion(List<Integer> input, int nrOfMoves) {
        ArrayList<Integer> newList = new ArrayList<>(input);
        Integer highest = input.stream().max(Integer::compare).get();
        for (int i = highest + 1; i <= 1000000; i++) {
            newList.add(i);
        }
        Cups cups = new Cups(newList);

        for (int i = 0; i < nrOfMoves; i++) {
            cups.doPickUp();
            cups.dropPickup();
            cups.pickNewCurrent();
        }
        return cups.findStars();
    }
}

package nl.mwensveen.adventofcode.year_2021.day_21;

import java.util.List;
import org.javatuples.Pair;

public class GameBoardParser {

    public Pair<Player, Player> parseGameBoard(List<String> input) {
        String player1Start = input.get(0).split(":")[1].trim();
        String player2Start = input.get(1).split(":")[1].trim();
        Player one = new Player(Integer.valueOf(player1Start));
        Player two = new Player(Integer.valueOf(player2Start));
        one.setName("one");
        two.setName("two");
        return Pair.with(one, two);
    }
}

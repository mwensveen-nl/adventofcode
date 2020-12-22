package nl.mwensveen.adventofcode.year_2020.day_22;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import nl.mwensveen.adventofcode.year_2020.day_22.Player.Builder;

public class InputParser {

    private static final String PLAYER_STRING = "Player ";
    private static final int PLAYER_STRING_LENGTH = PLAYER_STRING.length();

    public List<Player> parse(List<String> input) {
        List<Player.Builder> players = new ArrayList<>();
        Player.Builder player = null;
        for (String line : input) {
            if (line.startsWith(PLAYER_STRING)) {
                player = nextPlayer(line, players);
            } else if (!line.isEmpty()) {
                player.addSpaceCards(Integer.valueOf(line));
            }

        }
        return players.stream().map(pb -> pb.build()).collect(Collectors.toList());
    }

    private Builder nextPlayer(String line, List<Player.Builder> players) {
        Builder builder = Player.builder().withName(line.substring(PLAYER_STRING_LENGTH, line.length() - 1));
        players.add(builder);
        return builder;
    }

}

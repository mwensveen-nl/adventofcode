package nl.mwensveen.adventofcode.year_2023.day_02;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;

public class GameParser {

    public Table<Integer, Integer, CubeGrab> parseGames(List<String> input) {
        Table<Integer, Integer, CubeGrab> games = HashBasedTable.create();

        input.forEach(l -> parseGame(l, games));

        return games;
    }

    private void parseGame(String line, Table<Integer, Integer, CubeGrab> games) {
        String[] split = line.split(":");
        String gameNr = split[0];
        Integer nr = Integer.valueOf(gameNr.split(" ")[1]);

        String grabsString = split[1];
        String[] grabs = grabsString.split(";");
        for (int i = 0; i < grabs.length; i++) {
            games.put(nr, i, CubeGrab.parse(grabs[i]));
        }
    }
}

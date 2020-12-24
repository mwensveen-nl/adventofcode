package nl.mwensveen.adventofcode.year_2020.day_24;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class LobbyLayoutSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_24.txt");
    }

    @Override
    protected void part1() {
        FloorInstaller floorInstaller = new FloorInstaller();
        long result = floorInstaller.installTilesOnFloor(input);
        System.out.println("Number of tiles that are left with the black side up = " + result);
    }

    @Override
    protected void part2() {
        FloorCreator floorCreator = new FloorCreator();
        Table<Integer, Integer, Tile> floor = floorCreator.createFloor(input);

        LivingArtProcessor livingArtProcessor = new LivingArtProcessor();
        for (int i = 0; i < 100; i++) {
            floor = livingArtProcessor.flipTiles(floor);
        }

        BlackTileCounter blackTileCounter = new BlackTileCounter();
        long result = blackTileCounter.countBlackTiles(floor);

        System.out.println("Number of tiles that will be black after 100 days = " + result);
    }

    public static void main(String[] args) {
        new LobbyLayoutSolution().run();
    }

}

package nl.mwensveen.adventofcode.year_2020.day_24;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LivingArtProcessorTest {

    @Test
    public void testFlipTile() throws Exception {
        List<String> input = Arrays.asList("sesenwnenenewseeswwswswwnenewsewsw", "neeenesenwnwwswnenewnwwsewnenwseswesw", "seswneswswsenwwnwse",
                "nwnwneseeswswnenewneswwnewseswneseene", "swweswneswnenwsewnwneneseenw", "eesenwseswswnenwswnwnwsewwnwsene", "sewnenenenesenwsewnenwwwse",
                "wenwwweseeeweswwwnwwe", "wsweesenenewnwwnwsenewsenwwsesesenwne", "neeswseenwwswnwswswnw", "nenwswwsewswnenenewsenwsenwnesesenew",
                "enewnwewneswsewnwswenweswnenwsenwsw", "sweneswneswneneenwnewenewwneswswnese", "swwesenesewenwneswnwwneseswwne",
                "enesenwswwswneneswsenwnewswseenwsese", "wnwnesenesenenwwnenwsewesewsesesew", "nenewswnwewswnenesenwnesewesw",
                "eneswnwswnwsenenwnwnwwseeswneewsenese", "neswnwewnwnwseenwseesewsenwsweewe", "wseweeenwnesenwwwswnew");
        FloorCreator floorCreator = new FloorCreator();
        Table<Integer, Integer, Tile> floor = floorCreator.createFloor(input);

        LivingArtProcessor livingArtProcessor = new LivingArtProcessor();
        floor = livingArtProcessor.flipTiles(floor);
        BlackTileCounter blackTileCounter = new BlackTileCounter();
        assertEquals(15, blackTileCounter.countBlackTiles(floor));
    }

    @Test
    public void testFlipTile2() throws Exception {
        List<String> input = Arrays.asList("sesenwnenenewseeswwswswwnenewsewsw", "neeenesenwnwwswnenewnwwsewnenwseswesw", "seswneswswsenwwnwse",
                "nwnwneseeswswnenewneswwnewseswneseene", "swweswneswnenwsewnwneneseenw", "eesenwseswswnenwswnwnwsewwnwsene", "sewnenenenesenwsewnenwwwse",
                "wenwwweseeeweswwwnwwe", "wsweesenenewnwwnwsenewsenwwsesesenwne", "neeswseenwwswnwswswnw", "nenwswwsewswnenenewsenwsenwnesesenew",
                "enewnwewneswsewnwswenweswnenwsenwsw", "sweneswneswneneenwnewenewwneswswnese", "swwesenesewenwneswnwwneseswwne",
                "enesenwswwswneneswsenwnewswseenwsese", "wnwnesenesenenwwnenwsewesewsesesew", "nenewswnwewswnenesenwnesewesw",
                "eneswnwswnwsenenwnwnwwseeswneewsenese", "neswnwewnwnwseenwseesewsenwsweewe", "wseweeenwnesenwwwswnew");
        FloorCreator floorCreator = new FloorCreator();
        Table<Integer, Integer, Tile> floor = floorCreator.createFloor(input);

        LivingArtProcessor livingArtProcessor = new LivingArtProcessor();
        // day 1
        floor = livingArtProcessor.flipTiles(floor);

        // day 2
        floor = livingArtProcessor.flipTiles(floor);
        BlackTileCounter blackTileCounter = new BlackTileCounter();
        assertEquals(12, blackTileCounter.countBlackTiles(floor));

        // day 3
        floor = livingArtProcessor.flipTiles(floor);
        blackTileCounter = new BlackTileCounter();
        assertEquals(25, blackTileCounter.countBlackTiles(floor));
    }

    @Test
    public void testFlipTile100() throws Exception {
        List<String> input = Arrays.asList("sesenwnenenewseeswwswswwnenewsewsw", "neeenesenwnwwswnenewnwwsewnenwseswesw", "seswneswswsenwwnwse",
                "nwnwneseeswswnenewneswwnewseswneseene", "swweswneswnenwsewnwneneseenw", "eesenwseswswnenwswnwnwsewwnwsene", "sewnenenenesenwsewnenwwwse",
                "wenwwweseeeweswwwnwwe", "wsweesenenewnwwnwsenewsenwwsesesenwne", "neeswseenwwswnwswswnw", "nenwswwsewswnenenewsenwsenwnesesenew",
                "enewnwewneswsewnwswenweswnenwsenwsw", "sweneswneswneneenwnewenewwneswswnese", "swwesenesewenwneswnwwneseswwne",
                "enesenwswwswneneswsenwnewswseenwsese", "wnwnesenesenenwwnenwsewesewsesesew", "nenewswnwewswnenesenwnesewesw",
                "eneswnwswnwsenenwnwnwwseeswneewsenese", "neswnwewnwnwseenwseesewsenwsweewe", "wseweeenwnesenwwwswnew");
        FloorCreator floorCreator = new FloorCreator();
        Table<Integer, Integer, Tile> floor = floorCreator.createFloor(input);

        LivingArtProcessor livingArtProcessor = new LivingArtProcessor();
        for (int i = 0; i < 100; i++) {
            floor = livingArtProcessor.flipTiles(floor);
        }

        BlackTileCounter blackTileCounter = new BlackTileCounter();
        assertEquals(2208, blackTileCounter.countBlackTiles(floor));
    }

}

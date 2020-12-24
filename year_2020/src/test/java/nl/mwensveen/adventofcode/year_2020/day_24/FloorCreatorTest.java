package nl.mwensveen.adventofcode.year_2020.day_24;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FloorCreatorTest {

    @Test
    public void testCreateFloor() throws Exception {
        List<String> input = Arrays.asList("sesenwnenenewseeswwswswwnenewsewsw", "neeenesenwnwwswnenewnwwsewnenwseswesw", "seswneswswsenwwnwse",
                "nwnwneseeswswnenewneswwnewseswneseene", "swweswneswnenwsewnwneneseenw", "eesenwseswswnenwswnwnwsewwnwsene", "sewnenenenesenwsewnenwwwse",
                "wenwwweseeeweswwwnwwe", "wsweesenenewnwwnwsenewsenwwsesesenwne", "neeswseenwwswnwswswnw", "nenwswwsewswnenenewsenwsenwnesesenew",
                "enewnwewneswsewnwswenweswnenwsenwsw", "sweneswneswneneenwnewenewwneswswnese", "swwesenesewenwneswnwwneseswwne",
                "enesenwswwswneneswsenwnewswseenwsese", "wnwnesenesenenwwnenwsewesewsesesew", "nenewswnwewswnenesenwnesewesw",
                "eneswnwswnwsenenwnwnwwseeswneewsenese", "neswnwewnwnwseenwseesewsenwsweewe", "wseweeenwnesenwwwswnew");
        FloorCreator floorCreator = new FloorCreator();
        Table<Integer, Integer, Tile> floor = floorCreator.createFloor(input);

        assertEquals(Color.BLACK, floor.get(-1, -1).getColor());
        assertEquals(Color.BLACK, floor.get(-1, -3).getColor());
        assertEquals(Color.WHITE, floor.get(-2, -2).getColor());
        assertEquals(Color.WHITE, floor.get(-2, 0).getColor());
        assertEquals(Color.WHITE, floor.get(-2, 2).getColor());
        assertEquals(Color.WHITE, floor.get(-3, -1).getColor());
        assertEquals(Color.BLACK, floor.get(-3, 3).getColor());
        assertEquals(Color.WHITE, floor.get(0, -2).getColor());
        assertEquals(Color.BLACK, floor.get(0, -4).getColor());
        assertEquals(Color.BLACK, floor.get(0, 0).getColor());
        assertEquals(Color.BLACK, floor.get(0, 4).getColor());
        assertEquals(Color.BLACK, floor.get(1, -3).getColor());
        assertEquals(Color.BLACK, floor.get(2, -4).getColor());
        assertEquals(Color.BLACK, floor.get(2, 2).getColor());
        assertEquals(Color.BLACK, floor.get(3, -3).getColor());
    }

}

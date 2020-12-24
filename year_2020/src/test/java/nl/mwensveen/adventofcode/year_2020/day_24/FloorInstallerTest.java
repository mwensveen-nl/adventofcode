package nl.mwensveen.adventofcode.year_2020.day_24;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FloorInstallerTest {

    @Test
    public void testInstallTilesOnFloor() throws Exception {
        List<String> input = Arrays.asList("sesenwnenenewseeswwswswwnenewsewsw", "neeenesenwnwwswnenewnwwsewnenwseswesw", "seswneswswsenwwnwse",
                "nwnwneseeswswnenewneswwnewseswneseene", "swweswneswnenwsewnwneneseenw", "eesenwseswswnenwswnwnwsewwnwsene", "sewnenenenesenwsewnenwwwse",
                "wenwwweseeeweswwwnwwe", "wsweesenenewnwwnwsenewsenwwsesesenwne", "neeswseenwwswnwswswnw", "nenwswwsewswnenenewsenwsenwnesesenew",
                "enewnwewneswsewnwswenweswnenwsenwsw", "sweneswneswneneenwnewenewwneswswnese", "swwesenesewenwneswnwwneseswwne",
                "enesenwswwswneneswsenwnewswseenwsese", "wnwnesenesenenwwnenwsewesewsesesew", "nenewswnwewswnenesenwnesewesw",
                "eneswnwswnwsenenwnwnwwseeswneewsenese", "neswnwewnwnwseenwseesewsenwsweewe", "wseweeenwnesenwwwswnew");

        FloorInstaller floorInstaller = new FloorInstaller();
        assertEquals(10, floorInstaller.installTilesOnFloor(input));
    }

}

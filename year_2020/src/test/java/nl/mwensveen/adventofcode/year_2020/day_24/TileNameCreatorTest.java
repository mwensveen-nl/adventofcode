package nl.mwensveen.adventofcode.year_2020.day_24;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TileNameCreatorTest {

    @Test
    public void testCreateTileName() throws Exception {
        TileNameCreator creator = new TileNameCreator();
        assertEquals("sn=1,ew=-3", creator.createTileName("neeswseenwwswnwswswnw"));
    }

    @Test
    public void testCreateTileName2() throws Exception {
        TileNameCreator creator = new TileNameCreator();
        assertEquals("sn=0,ew=0", creator.createTileName("nesw"));
    }

    @Test
    public void testCreateTileName3() throws Exception {
        TileNameCreator creator = new TileNameCreator();
        assertEquals("sn=-3,ew=-1", creator.createTileName("neeenesenwnwwswnenewnwwsewnenwseswesw"));
    }

    @Test
    public void testCreateTileName4() throws Exception {
        TileNameCreator creator = new TileNameCreator();
        assertEquals("sn=2,ew=-4", creator.createTileName("sesenwnenenewseeswwswswwnenewsewsw"));
    }

}

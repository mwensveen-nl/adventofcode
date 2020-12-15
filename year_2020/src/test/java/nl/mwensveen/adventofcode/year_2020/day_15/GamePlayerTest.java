package nl.mwensveen.adventofcode.year_2020.day_15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GamePlayerTest {

    @Test
    public void testFindNumber() throws Exception {
        List<Long> input = Arrays.asList(0L, 3L, 6L);
        GamePlayer gamePlayer = new GamePlayer();
        assertEquals(0, gamePlayer.findNumber(4, input));
        assertEquals(3, gamePlayer.findNumber(5, input));
        assertEquals(3, gamePlayer.findNumber(6, input));
        assertEquals(1, gamePlayer.findNumber(7, input));
        assertEquals(0, gamePlayer.findNumber(8, input));
        assertEquals(4, gamePlayer.findNumber(9, input));
        assertEquals(0, gamePlayer.findNumber(10, input));
        assertEquals(436, gamePlayer.findNumber(2020, input));
        assertEquals(175594, gamePlayer.findNumber(30000000, input));
    }

    @Test
    public void testFindNumber2() throws Exception {
        List<Long> input = Arrays.asList(1L, 3L, 2L);
        GamePlayer gamePlayer = new GamePlayer();
        assertEquals(1, gamePlayer.findNumber(2020, input));
    }

    @Test
    public void testFindNumber3() throws Exception {
        List<Long> input = Arrays.asList(2L, 1L, 3L);
        GamePlayer gamePlayer = new GamePlayer();
        assertEquals(10, gamePlayer.findNumber(2020, input));
    }

    @Test
    public void testFindNumber4() throws Exception {
        List<Long> input = Arrays.asList(1L, 2L, 3L);
        GamePlayer gamePlayer = new GamePlayer();
        assertEquals(27, gamePlayer.findNumber(2020, input));
    }

    @Test
    public void testFindNumber5() throws Exception {
        List<Long> input = Arrays.asList(2L, 3L, 1L);
        GamePlayer gamePlayer = new GamePlayer();
        assertEquals(78, gamePlayer.findNumber(2020, input));
    }

    @Test
    public void testFindNumber6() throws Exception {
        List<Long> input = Arrays.asList(3L, 2L, 1L);
        GamePlayer gamePlayer = new GamePlayer();
        assertEquals(438, gamePlayer.findNumber(2020, input));
    }

    @Test
    public void testFindNumber7() throws Exception {
        List<Long> input = Arrays.asList(3L, 1L, 2L);
        GamePlayer gamePlayer = new GamePlayer();
        assertEquals(1836, gamePlayer.findNumber(2020, input));
    }

}

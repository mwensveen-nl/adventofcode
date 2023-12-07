package nl.mwensveen.adventofcode.year_2023.day_07;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePlayerTest {
    private String input = """
            32T3K 765
            T55J5 684
            KK677 28
            KTJJT 220
            QQQJA 483
                    """;

    @Test
    public void testPlayGame() {
        List<HandBid> list = new GameParser().parse(input.lines().toList());
        long result = new GamePlayer().playGame(list);
        assertEquals(6440, result);
    }

}

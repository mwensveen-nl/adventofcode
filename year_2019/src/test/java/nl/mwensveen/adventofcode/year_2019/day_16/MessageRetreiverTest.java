package nl.mwensveen.adventofcode.year_2019.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MessageRetreiverTest {

    @Test
    public void testRetrieve() throws Exception {
        MessageRetreiver messageRetreiver = new MessageRetreiver();
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> output = Arrays.asList(8, 0, 8, 7, 1, 2, 2, 4, 5, 8, 5, 9, 1, 4, 5, 4, 6, 6, 1, 9, 0, 8, 3, 2, 1, 8, 6, 4, 5, 5, 9, 5);

        String message = messageRetreiver.retrieve(input, 0, output);
        assertEquals("80871224", message);
    }

    public void testRetrieveNull() throws Exception {
        MessageRetreiver messageRetreiver = new MessageRetreiver();
        List<Integer> input = null;
        List<Integer> output = Arrays.asList(8, 0, 8, 7, 1, 2, 2, 4, 5, 8, 5, 9, 1, 4, 5, 4, 6, 6, 1, 9, 0, 8, 3, 2, 1, 8, 6, 4, 5, 5, 9, 5);

        String message = messageRetreiver.retrieve(input, 0, output);
        assertEquals("80871224", message);
    }

    public void testRetrieve2() throws Exception {
        MessageRetreiver messageRetreiver = new MessageRetreiver();
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> output = Arrays.asList(8, 0, 8, 7, 1, 2, 2, 4, 5, 8, 5, 9, 1, 4, 5, 4, 6, 6, 1, 9, 0, 8, 3, 2, 1, 8, 6, 4, 5, 5, 9, 5);

        String message = messageRetreiver.retrieve(input, 2, output);
        assertEquals("14546619", message);
    }

}

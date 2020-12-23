package nl.mwensveen.adventofcode.year_2020.day_23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CupsTest {

    @Test
    public void testDoPickUp() throws Exception {
        List<Integer> input = Arrays.asList(3, 8, 9, 1, 2, 5, 4, 6, 7);
        Cups cups = Cups.builder().addCircle(input).build();

        List<Integer> expected = Arrays.asList(8, 9, 1);
        assertEquals(expected, cups.doPickUp());
    }

    @Test
    public void testDropPickup() throws Exception {
        List<Integer> input = Arrays.asList(3, 8, 9, 1, 2, 5, 4, 6, 7);
        Cups cups = Cups.builder().addCircle(input).build();
        cups.doPickUp();
        assertEquals(Integer.valueOf(2), cups.dropPickup());
    }

    @Test
    public void testPickNewCurrent() throws Exception {
        List<Integer> input = Arrays.asList(3, 8, 9, 1, 2, 5, 4, 6, 7);
        Cups cups = Cups.builder().addCircle(input).build();
        cups.doPickUp();
        cups.dropPickup();
        assertEquals(Integer.valueOf(2), cups.pickNewCurrent());
    }

    @Test
    public void testDoPickUp2() throws Exception {
        List<Integer> input = Arrays.asList(3, 8, 9, 1, 2, 5, 4, 6, 7);
        Cups cups = Cups.builder().addCircle(input).build();
        cups.doPickUp();
        cups.dropPickup();
        cups.pickNewCurrent();

        List<Integer> expected = Arrays.asList(8, 9, 1);
        assertEquals(expected, cups.doPickUp());
        assertEquals(Integer.valueOf(7), cups.dropPickup());
        assertEquals(Integer.valueOf(5), cups.pickNewCurrent());
    }

    @Test
    public void testFinishedLabels() throws Exception {
        List<Integer> input = Arrays.asList(3, 8, 9, 1, 2, 5, 4, 6, 7);
        Cups cups = Cups.builder().addCircle(input).build();
        assertEquals("25467389", cups.finishedLabels());
    }

}

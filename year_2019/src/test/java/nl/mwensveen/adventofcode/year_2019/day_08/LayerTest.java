package nl.mwensveen.adventofcode.year_2019.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LayerTest {

    @Test
    public void testIsFull() throws Exception {
        String input = "123456";
        Layer l = new Layer(3, 2);
        for (int i = 0; i < input.length(); i++) {
            l.addPixel(Integer.valueOf(input.substring(i, i + 1)));
        }
        assertTrue(l.isFull());
    }

    public void testCount() throws Exception {
        String input = "121456";
        Layer l = new Layer(3, 2);
        for (int i = 0; i < input.length(); i++) {
            l.addPixel(Integer.valueOf(input.substring(i, i + 1)));
        }
        assertEquals(2, l.countPixelsOfColor(1));
    }

    public void testCount0() throws Exception {
        String input = "121456";
        Layer l = new Layer(3, 2);
        for (int i = 0; i < input.length(); i++) {
            l.addPixel(Integer.valueOf(input.substring(i, i + 1)));
        }
        assertEquals(0, l.countPixelsOfColor(1));
    }

}

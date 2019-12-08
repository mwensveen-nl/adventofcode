package nl.mwensveen.adventofcode.year_2019.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ImageTest {

    @Test
    public void testImage() throws Exception {
        String input = "123456789012";
        Image image = new Image(3, 2);
        for (int i = 0; i < input.length(); i++) {
            image.addPixel(Integer.valueOf(input.substring(i, i + 1)));
        }
        assertEquals(2, image.numberOfLayers());
        assertTrue(image.getLayer(0).isFull());
        assertTrue(image.getLayer(1).isFull());
    }

}

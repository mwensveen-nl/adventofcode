package nl.mwensveen.adventofcode.year_2019.day_08;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ImageRendererTest {

    @Test
    public void testRenderImage() throws Exception {
        String input = "0222112222120000";
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            ints.add(Integer.parseInt(input.substring(i, i + 1)));
        }

        ImageDecoder decoder = new ImageDecoder();
        Image image = decoder.decodeImage(ints, 2, 2);
        ImageRenderer imageRenderer = new ImageRenderer(image, 2, 2);
        imageRenderer.renderImage();

    }

}

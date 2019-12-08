package nl.mwensveen.adventofcode.year_2019.day_08;

import java.util.List;

public class ImageDecoder {

    public Image decodeImage(List<Integer> input, int wide, int tall) {

        Image image = new Image(wide, tall);
        input.forEach(pixel -> image.addPixel(pixel));
        return image;
    }

}

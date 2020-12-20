package nl.mwensveen.adventofcode.year_2020.day_20;

import java.util.List;

public class ImageParser {

    private static final String TILE = "Tile ";
    private static final int TILE_LENGTH = TILE.length();

    public Image parser(List<String> input) {
        String idString = input.get(0);

        Image image = new Image(idString.substring(TILE_LENGTH, idString.length() - 1));
        input.stream().skip(1).forEach(in -> addToImage(image, in));
        return image;
    }

    private void addToImage(Image image, String in) {
        image.addLine(in);
    }
}
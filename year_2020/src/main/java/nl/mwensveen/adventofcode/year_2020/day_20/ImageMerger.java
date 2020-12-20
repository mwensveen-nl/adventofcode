package nl.mwensveen.adventofcode.year_2020.day_20;

import java.util.ArrayList;
import java.util.List;

public class ImageMerger {

    public Image merge(Grid grid) {
        List<String> newImage = new ArrayList<>();
        int newImageRow = 0;
        for (int r = grid.getMinX(); r <= grid.getMaxX(); r++) {
            for (int c = grid.getMinY(); c <= grid.getMaxY(); c++) {
                Image image = grid.get(r, c);
                int length = image.getRow(0).length();
                for (int ir = 1; ir < length - 1; ir++) {
                    append(newImage, newImageRow + ir - 1, image.getRow(ir).substring(1, length - 1));
                }
            }
            newImageRow = newImage.size();
        }
        newImage.add(0, "Tile 0");
        ImageParser imageParser = new ImageParser();
        return imageParser.parser(newImage);
    }

    private void append(List<String> newImage, int i, String substring) {
        if (i >= newImage.size()) {
            newImage.add(i, substring);
        } else {
            String row = newImage.get(i);
            newImage.set(i, row + substring);
        }
    }
}

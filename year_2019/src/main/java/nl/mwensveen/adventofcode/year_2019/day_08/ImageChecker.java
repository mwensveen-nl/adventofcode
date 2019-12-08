package nl.mwensveen.adventofcode.year_2019.day_08;

public class ImageChecker {
    private int max = Integer.MAX_VALUE;
    private int checksum = 0;

    public int checkImage(Image image) {
        for (int i = 0; i < image.numberOfLayers(); i++) {
            Layer layer = image.getLayer(i);
            int countPixelsOfColor = layer.countPixelsOfColor(0);
            if (countPixelsOfColor < max) {
                max = countPixelsOfColor;
                checksum = layer.countPixelsOfColor(1) * layer.countPixelsOfColor(2);
            }
        }
        return checksum;
    }
}

package nl.mwensveen.adventofcode.year_2019.day_08;

public class ImageRenderer {
    private static final Integer black = 0;
    private static final Integer white = 1;
    private static final Integer transparrent = 2;

    private Image image;
    private int wide;
    private int tall;

    public ImageRenderer(Image image, int wide, int tall) {
        super();
        this.image = image;
        this.wide = wide;
        this.tall = tall;
    }

    public void renderImage() {
        int layerCount = image.numberOfLayers();
        for (int t = 0; t < tall; t++) {
            for (int w = 0; w < wide; w++) {
                for (int l = 0; l < layerCount; l++) {
                    Integer pixel = image.getLayer(l).getRow(t).get(w);
                    if (!transparrent.equals(pixel)) {
                        printPixel(pixel);
                        break;
                    }
                }
            }
            System.out.println();
        }
    }

    private void printPixel(Integer pixel) {
        if (black.equals(pixel)) {
            System.out.print(" ");
        } else {
            System.out.print("'");
        }
    }
}

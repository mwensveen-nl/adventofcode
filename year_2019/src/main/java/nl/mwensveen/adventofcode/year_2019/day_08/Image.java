package nl.mwensveen.adventofcode.year_2019.day_08;

import java.util.ArrayList;
import java.util.List;

public class Image {

    private List<Layer> layers = new ArrayList<>();
    private Layer currentLayer;
    private int wide;
    private int tall;

    public Image(int wide, int tall) {
        this.wide = wide;
        this.tall = tall;
        newLayer();
    }

    private void newLayer() {
        currentLayer = new Layer(wide, tall);
        layers.add(currentLayer);
    }

    public void addPixel(Integer pixel) {
        if (currentLayer.isFull()) {
            newLayer();
        }
        currentLayer.addPixel(pixel);
    }

    public int numberOfLayers() {
        return layers.size();
    }

    public Layer getLayer(int i) {
        return layers.get(i);
    }
}

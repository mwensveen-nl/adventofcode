package nl.mwensveen.adventofcode.year_2017.day_13;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PacketScanners {

    private List<Layer> layerList;
    private String input;

    public PacketScanners(String input) {
        this.input = input;
        layerList = toLayerList(input);
    }

    public long calculate() {
        List<Layer> caught = layerList.stream().filter(l -> l.isOnTop(l.getNumber())).collect(Collectors.toList());
        return caught.stream().map(l -> l.getNumber() * l.getDepth()).collect(Collectors.summarizingInt(i -> i)).getSum();
    }

    public int calculateDelay() {
        int delay = 0;
        while (isCaught(delay)) {
            delay++;
        }
        return delay;
    }

    private boolean isCaught(int delay) {
        System.out.println(delay);
        boolean caught = false;
        for (int i = 0; i < layerList.size() && !caught; i++) {
            Layer layer = layerList.get(i);
            caught = layer.isOnTop(layer.getNumber() + delay);

        }
        return caught;
    }

    private List<Layer> toLayerList(String in) {
        Iterable<String> split = Splitter.on("\n")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        List<Layer> list = newArrayList.stream().map(s -> toLayer(s)).collect(Collectors.toList());
        return list;
    }

    private Layer toLayer(String in) {
        Iterable<String> split = Splitter.on(":")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        Layer layer = new Layer(Integer.valueOf(newArrayList.get(0)), Integer.valueOf(newArrayList.get(1)));
        return layer;
    }
}

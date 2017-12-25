package nl.mwensveen.adventofcode.year_2017.day_24;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElectromagneticMoat {

    private List<Component> components;
    private int maxStrength = 0;
    private int maxSize = 0;
    private int maxStrengthOfMaxSize = 0;

    public ElectromagneticMoat(String input) {
        components = toComponentsList(input);
    }

    public int calculate() {
        processPort("0", components, 0, 0);
        return maxStrength;
    }

    public int calculateLongestBridge() {
        processPort("0", components, 0, 0);
        return maxStrengthOfMaxSize;
    }

    private void processPort(String port, List<Component> leftComponents, int currentStrength, int currentSize) {
        for (Component component : leftComponents) {
            if (component.hasPort(port)) {
                // part 1
                int newStrenght = currentStrength + component.strenght();
                maxStrength = Math.max(maxStrength, newStrenght);
                // part 2
                int newSize = currentSize + 1;
                if (newSize > maxSize) {
                    maxSize = newSize;
                    maxStrengthOfMaxSize = newStrenght;
                } else if (newSize == maxSize) {
                    maxStrengthOfMaxSize = Math.max(maxStrengthOfMaxSize, newStrenght);
                }
                processPort(component.otherPort(port), removeComponentFromList(component, leftComponents), newStrenght, newSize);
            }
        }

    }

    private List<Component> removeComponentFromList(Component component, List<Component> leftComponents) {
        List<Component> cs = new ArrayList<>(leftComponents);
        cs.remove(component);
        return cs;
    }

    private static ArrayList<String> split(String in, String splitString) {
        Iterable<String> split = Splitter.on(splitString)
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        return newArrayList;
    }

    private List<Component> toComponentsList(String input) {
        return split(input, "\n").stream().map(s -> toComponent(s)).collect(Collectors.toList());
    }

    private Component toComponent(String s) {
        ArrayList<String> list = split(s, "/");
        return Component.builder().setPortA(list.get(0)).setPortB(list.get(1)).build();
    }
}

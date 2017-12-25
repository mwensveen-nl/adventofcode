package nl.mwensveen.adventofcode.year_2017.day_24;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElectromagneticMoat {

    private List<Component> components;
    private int maxStrength = 0;

    public ElectromagneticMoat(String input) {
        components = toComponentsList(input);
    }

    public int calculate() {
        processPort("0", components, 0);
        return maxStrength;
    }

    private void processPort(String port, List<Component> leftComponents, int currentStrength) {
        for (Component component : leftComponents) {
            if (component.hasPort(port)) {
                int newStrenght = currentStrength + component.strenght();
                maxStrength = Math.max(maxStrength, newStrenght);
                processPort(component.otherPort(port), removeComponentFromList(component, leftComponents), newStrenght);
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

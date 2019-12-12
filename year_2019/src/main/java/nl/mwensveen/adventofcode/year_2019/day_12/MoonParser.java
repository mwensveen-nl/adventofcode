package nl.mwensveen.adventofcode.year_2019.day_12;

import java.util.ArrayList;
import java.util.List;

public class MoonParser {

    public List<Moon> parseMoons(List<String> lines) {
        List<Moon> moons = new ArrayList<>();
        for (String line : lines) {

            String[] parts = line.substring(1, line.length() - 1).split(",");
            Moon moon = new Moon(parsePosition(parts[0]), parsePosition(parts[1]), parsePosition(parts[2]));
            moons.add(moon);
        }
        return moons;
    }

    private int parsePosition(String part) {
        int i = part.indexOf("=");
        return Integer.parseInt(part.substring(i + 1));
    }
}

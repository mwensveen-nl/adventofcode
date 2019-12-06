package nl.mwensveen.adventofcode.year_2019.day_06;

import com.google.common.base.MoreObjects;

public class OrbitEntry {

    private final String base;
    private final String satellite;

    public OrbitEntry(String input) {
        int index = input.indexOf(')');
        base = input.substring(0, index);
        satellite = input.substring(index + 1);
    }

    public String getBase() {
        return base;
    }

    public String getSatellite() {
        return satellite;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("base", base).add("satellite", satellite).toString();
    }

}

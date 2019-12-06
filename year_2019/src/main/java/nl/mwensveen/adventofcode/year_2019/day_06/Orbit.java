package nl.mwensveen.adventofcode.year_2019.day_06;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;

public class Orbit {

    private final String name;
    private Orbit base;
    private final List<Orbit> satellites = new ArrayList<>();

    public Orbit(String name) {
        this.name = name;
    }

    public void addSatellite(Orbit s) {
        satellites.add(s);
    }

    public List<Orbit> getSatellites() {
        return satellites;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Orbit)) {
            return false;
        }
        Orbit castOther = (Orbit) other;
        return Objects.equal(name, castOther.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("base", name).toString();
    }

    public Orbit getBase() {
        return base;
    }

    public void setBase(Orbit base) {
        this.base = base;
    }

    public String getName() {
        return name;
    }

}

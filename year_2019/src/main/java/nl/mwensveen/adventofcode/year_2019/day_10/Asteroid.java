package nl.mwensveen.adventofcode.year_2019.day_10;

import com.google.common.base.MoreObjects;
import java.util.HashSet;
import java.util.Set;

public class Asteroid {
    private final Point point;

    private final Set<Asteroid> detectable = new HashSet<>();
    private final Set<Asteroid> notDetectable = new HashSet<>();

    public Asteroid(Point point) {
        super();
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public Set<Asteroid> getDetectable() {
        return detectable;
    }

    public Set<Asteroid> getNotDetectable() {
        return notDetectable;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("point", point).add("detectable", detectable.size()).add("notDetectable", notDetectable.size()).toString();
    }

}

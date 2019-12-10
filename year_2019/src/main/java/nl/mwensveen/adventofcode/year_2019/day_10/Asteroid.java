package nl.mwensveen.adventofcode.year_2019.day_10;

import com.google.common.base.MoreObjects;
import java.util.HashSet;
import java.util.Set;

public class Asteroid {
    private final Point point;

    private final Set<Asteroid> detectable = new HashSet<>();
    private final Set<Asteroid> notDetectable = new HashSet<>();

    private double angleFromBase = 0;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("point", point).add("angleFromBase", angleFromBase).add("detectable", detectable.size())
                .add("notDetectable", notDetectable.size()).toString();
    }

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

    public double getAngleFromBase() {
        return angleFromBase;
    }

    public void setAngleFromBase(double angleFromBase) {
        this.angleFromBase = angleFromBase;
    }

    public void resetDetectable() {
        detectable.clear();
        notDetectable.clear();
    }

}

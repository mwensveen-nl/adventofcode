package nl.mwensveen.adventofcode.year_2019.day_12;

import java.util.List;

public class VelocityApplier {

    public void applyVelocity(List<Moon> moons) {
        moons.forEach(m -> {
            m.UpdatePosition(m.getPositionX() + m.getVelocityX(), m.getPositionY() + m.getVelocityY(), m.getPositionZ() + m.getVelocityZ());
        });
    }
}

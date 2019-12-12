package nl.mwensveen.adventofcode.year_2019.day_12;

import com.codepoetics.protonpack.StreamUtils;
import java.util.List;

public class GravityApplier {

    public void apply(List<Moon> moons) {
        StreamUtils.zipWithIndex(moons.stream()).forEach(entry -> applyGravity(entry.getValue(), moons.subList((int) entry.getIndex() + 1, moons.size())));
    }

    private Object applyGravity(Moon baseMoon, List<Moon> moons) {
        moons.stream().forEach(m -> applyGravity(baseMoon, m));
        return null;
    }

    private void applyGravity(Moon baseMoon, Moon m) {
        if (baseMoon.getPositionX() > m.getPositionX()) {
            baseMoon.increaseVelocityX(-1);
            m.increaseVelocityX(1);
        } else if (baseMoon.getPositionX() < m.getPositionX()) {
            baseMoon.increaseVelocityX(1);
            m.increaseVelocityX(-1);
        }
        if (baseMoon.getPositionY() > m.getPositionY()) {
            baseMoon.increaseVelocityY(-1);
            m.increaseVelocityY(1);
        } else if (baseMoon.getPositionY() < m.getPositionY()) {
            baseMoon.increaseVelocityY(1);
            m.increaseVelocityY(-1);
        }
        if (baseMoon.getPositionZ() > m.getPositionZ()) {
            baseMoon.increaseVelocityZ(-1);
            m.increaseVelocityZ(1);
        } else if (baseMoon.getPositionZ() < m.getPositionZ()) {
            baseMoon.increaseVelocityZ(1);
            m.increaseVelocityZ(-1);
        }
    }
}

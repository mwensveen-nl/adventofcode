package nl.mwensveen.adventofcode.year_2021.day_02;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PositionCalculator {

    int calculateSimplePostion(List<String> input) {
        AtomicInteger horizontal = new AtomicInteger();
        AtomicInteger depth = new AtomicInteger();

        input.stream().map(s -> new Step(s)).forEach(step -> applySimpleStep(step, horizontal, depth));

        return horizontal.intValue() * depth.intValue();
    }

    private void applySimpleStep(Step step, AtomicInteger horizontal, AtomicInteger depth) {
        switch (step.getDirection()) {
            case FORWARD:
                horizontal.addAndGet(step.getNumber());
                break;
            case UP:
                depth.addAndGet(-1 * step.getNumber());
                break;
            case DOWN:
                depth.addAndGet(step.getNumber());
                break;
            default:
                break;
        }
    }

    int calculatePostionWithAim(List<String> input) {
        AtomicInteger horizontal = new AtomicInteger();
        AtomicInteger depth = new AtomicInteger();
        AtomicInteger aim = new AtomicInteger();

        input.stream().map(s -> new Step(s)).forEach(step -> applyStepWithAim(step, horizontal, depth, aim));

        return horizontal.intValue() * depth.intValue();
    }

    private void applyStepWithAim(Step step, AtomicInteger horizontal, AtomicInteger depth, AtomicInteger aim) {
        switch (step.getDirection()) {
            case FORWARD:
                horizontal.addAndGet(step.getNumber());
                depth.addAndGet(aim.intValue() * step.getNumber());
                break;
            case UP:
                aim.addAndGet(-1 * step.getNumber());
                break;
            case DOWN:
                aim.addAndGet(step.getNumber());
                break;
            default:
                break;
        }
    }
}

package nl.mwensveen.adventofcode.year_2021.day_02;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PositionCalculator {

    int calculateSimplePostion(List<String> input) {
        AtomicInteger horizontal = new AtomicInteger();
        AtomicInteger depth = new AtomicInteger();

        input.stream().map(s -> Step.parse(s)).forEach(step -> applySimpleStep(step, horizontal, depth));

        return horizontal.intValue() * depth.intValue();
    }

    private void applySimpleStep(Step step, AtomicInteger horizontal, AtomicInteger depth) {
        switch (step.direction()) {
            case FORWARD:
                horizontal.addAndGet(step.number());
                break;
            case UP:
                depth.addAndGet(-1 * step.number());
                break;
            case DOWN:
                depth.addAndGet(step.number());
                break;
            default:
                break;
        }
    }

    int calculatePostionWithAim(List<String> input) {
        AtomicInteger horizontal = new AtomicInteger();
        AtomicInteger depth = new AtomicInteger();
        AtomicInteger aim = new AtomicInteger();

        input.stream().map(s -> Step.parse(s)).forEach(step -> applyStepWithAim(step, horizontal, depth, aim));

        return horizontal.intValue() * depth.intValue();
    }

    private void applyStepWithAim(Step step, AtomicInteger horizontal, AtomicInteger depth, AtomicInteger aim) {
        switch (step.direction()) {
            case FORWARD:
                horizontal.addAndGet(step.number());
                depth.addAndGet(aim.intValue() * step.number());
                break;
            case UP:
                aim.addAndGet(-1 * step.number());
                break;
            case DOWN:
                aim.addAndGet(step.number());
                break;
            default:
                break;
        }
    }
}

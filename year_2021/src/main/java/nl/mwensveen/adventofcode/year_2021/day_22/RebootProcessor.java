package nl.mwensveen.adventofcode.year_2021.day_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RebootProcessor {

    Long processReboot(List<Step> steps) {
        List<Step> reactor = new ArrayList<>();

        steps.forEach(s -> processRebootStep(s, reactor));

        return reactor.stream().collect(Collectors.summingLong(s -> s.size()));
    }

    private void processRebootStep(Step nextStep, List<Step> reactorOn) {
        for (int i = 0; i < reactorOn.size(); i++) {
            Step step = reactorOn.get(i);
            if (same(nextStep, step)) {
                if (nextStep.getOnOff().equals("off")) {
                    reactorOn.remove(i);
                }
                return;
            } else {
                if (overlap(step, nextStep)) {
                    List<Step> steps = splitX(step, nextStep.getStartX(), nextStep.getEndX());
                    steps = steps.stream().flatMap(s -> splitY(s, nextStep.getStartY(), nextStep.getEndY()).stream()).toList();
                    steps = steps.stream().flatMap(s -> splitZ(s, nextStep.getStartZ(), nextStep.getEndZ()).stream()).toList();
                    reactorOn.remove(i);
                    reactorOn.addAll(i, steps);

                    List<Step> nextSteps = splitX(nextStep, step.getStartX(), step.getEndX());
                    nextSteps = nextSteps.stream().flatMap(s -> splitY(s, step.getStartY(), step.getEndY()).stream()).toList();
                    nextSteps = nextSteps.stream().flatMap(s -> splitZ(s, step.getStartZ(), step.getEndZ()).stream()).toList();

                    nextSteps.forEach(s -> processRebootStep(s, reactorOn));
                    return;
                }
            }
        }
        if (nextStep.getOnOff().equals("on")) {
            reactorOn.add(nextStep);
        }
    }

    private List<Step> splitX(Step step, int start, int end) {
        if (step.getStartX() == start) {
            if (step.getEndX() <= end) {
                return Arrays.asList(step);
            } else {
                return Arrays.asList(step.toBuilder().withEndX(end).build(), step.toBuilder().withStartX(end + 1).build());
            }
        }
        if (step.getStartX() < start) {
            if (step.getEndX() <= end) {
                return Arrays.asList(step.toBuilder().withEndX(start - 1).build(), step.toBuilder().withStartX(start).build());
            } else {
                return Arrays.asList(step.toBuilder().withEndX(start - 1).build(), step.toBuilder().withStartX(start).withEndX(end).build(),
                        step.toBuilder().withStartX(end + 1).build());
            }

        }
        if (step.getEndX() > end) {
            return Arrays.asList(step.toBuilder().withEndX(end).build(), step.toBuilder().withStartX(end + 1).build());
        }
        return Arrays.asList(step);
    }

    private List<Step> splitY(Step step, int start, int end) {
        if (step.getStartY() == start) {
            if (step.getEndY() <= end) {
                return Arrays.asList(step);
            } else {
                return Arrays.asList(step.toBuilder().withEndY(end).build(), step.toBuilder().withStartY(end + 1).build());
            }
        }
        if (step.getStartY() < start) {
            if (step.getEndY() <= end) {
                return Arrays.asList(step.toBuilder().withEndY(start - 1).build(), step.toBuilder().withStartY(start).build());
            } else {
                return Arrays.asList(step.toBuilder().withEndY(start - 1).build(), step.toBuilder().withStartY(start).withEndY(end).build(),
                        step.toBuilder().withStartY(end + 1).build());
            }

        }
        if (step.getEndY() > end) {
            return Arrays.asList(step.toBuilder().withEndY(end).build(), step.toBuilder().withStartY(end + 1).build());
        }
        return Arrays.asList(step);
    }

    private List<Step> splitZ(Step step, int start, int end) {
        if (step.getStartZ() == start) {
            if (step.getEndZ() <= end) {
                return Arrays.asList(step);
            } else {
                return Arrays.asList(step.toBuilder().withEndZ(end).build(), step.toBuilder().withStartZ(end + 1).build());
            }
        }
        if (step.getStartZ() < start) {
            if (step.getEndZ() <= end) {
                return Arrays.asList(step.toBuilder().withEndZ(start - 1).build(), step.toBuilder().withStartZ(start).build());
            } else {
                return Arrays.asList(step.toBuilder().withEndZ(start - 1).build(), step.toBuilder().withStartZ(start).withEndZ(end).build(),
                        step.toBuilder().withStartZ(end + 1).build());
            }

        }
        if (step.getEndZ() > end) {
            return Arrays.asList(step.toBuilder().withEndZ(end).build(), step.toBuilder().withStartZ(end + 1).build());
        }
        return Arrays.asList(step);
    }

    private boolean overlap(Step step, Step nextStep) {
        return (inStep(step.getStartX(), nextStep.getStartX(), nextStep.getEndX()) || inStep(nextStep.getStartX(), step.getStartX(), step.getEndX())) &&
                (inStep(step.getStartY(), nextStep.getStartY(), nextStep.getEndY()) || inStep(nextStep.getStartY(), step.getStartY(), step.getEndY())) &&
                (inStep(step.getStartZ(), nextStep.getStartZ(), nextStep.getEndZ()) || inStep(nextStep.getStartZ(), step.getStartZ(), step.getEndZ()));
    }

    private boolean inStep(int value, int start, int end) {
        return start <= value && value <= end;
    }

    private boolean same(Step nextStep, Step step) {
        return nextStep.getStartX() == step.getStartX() &&
                nextStep.getEndX() == step.getEndX() &&
                nextStep.getStartY() == step.getStartY() &&
                nextStep.getEndY() == step.getEndY() &&
                nextStep.getStartZ() == step.getStartZ() &&
                nextStep.getEndZ() == step.getEndZ();
    }
}

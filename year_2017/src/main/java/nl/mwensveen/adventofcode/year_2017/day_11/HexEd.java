package nl.mwensveen.adventofcode.year_2017.day_11;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HexEd {

    private int x = 0;
    private int y = 0;
    private List<Step> steps;
    private int furthestAway = 0;

    public HexEd(String input) {
        steps = toStepList(input);
    }

    public int calculate() {
        steps.forEach(step -> performStep(step));
        return calculateStepsRemoved();
    }

    public int calculateFurthestAway() {
        steps.forEach(step -> {
            performStep(step);
            furthestAway = Math.max(furthestAway, calculateStepsRemoved());
        });
        return furthestAway;
    }

    private int calculateStepsRemoved() {
        int ax = Math.abs(x);
        int ay = Math.abs(y);

        int stepsRemove = ax;
        ay = ay - ax;
        if (ay > 0) {
            stepsRemove = stepsRemove + ay / 2;
        }
        return stepsRemove;
    }

    private void performStep(Step step) {
        x = x + step.getX();
        y = y + step.getY();
    }

    private List<Step> toStepList(String in) {
        Iterable<String> split = Splitter.on(",")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        List<Step> list = newArrayList.stream().map(s -> Step.valueOf(s)).collect(Collectors.toList());
        System.out.println(list);
        return list;

    }
}

package nl.mwensveen.adventofcode.year_2022.day_10;

import java.util.List;

public class ProgramExecution {

    public int executeSummingProgram(List<String> input) {
        Cycle c = new Cycle(0, 0, 1, 1);
        EvaluateCycle evalCycle = new EvaluateCycle();
        for (String instruction : input) {
            c = executeInstruction(instruction, c);
            evalCycle = evaluateCycle(c, evalCycle);
            if (evalCycle.done()) {
                break;
            }
        }
        return evalCycle.getSum();
    }

    public CRTscreen executeDrawingProgram(List<String> input) {
        CRTscreen crtScreen = new CRTscreen();
        Cycle c = new Cycle(0, 0, 1, 1);

        for (String instruction : input) {
            c = executeInstruction(instruction, c);
            crtScreen.draw(c);
        }
        return crtScreen;
    }

    public Cycle executeInstruction(String instruction, Cycle current) {
        String[] split = instruction.split(" ");
        Cycle next = switch (split[0]) {
            case "noop" -> new Cycle(current.end() + 1, current.end() + 1, current.endValue(), current.endValue());
            case "addx" -> new Cycle(current.end() + 1, current.end() + 2, current.endValue(), current.endValue() + Integer.parseInt(split[1]));
            default -> throw new IllegalArgumentException("Unexpected value: " + instruction);
        };
        return next;
    }

    public EvaluateCycle evaluateCycle(Cycle c, EvaluateCycle evalCycle) {
        int ec = evalCycle.getCycleNumber();
        if (ec >= c.begin() && ec <= c.end()) {
            evalCycle.addSum(c.beginValue() * ec);
            evalCycle.removeCycle();
        }
        return evalCycle;
    }
}

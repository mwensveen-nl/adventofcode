package nl.mwensveen.adventofcode.year_2017.day_25;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class HaltingProblem {
    Map<String, State> states = new HashMap<>();
    int number = 0;
    Map<Integer, Integer> tape = new HashMap<>();
    Integer currentTapePos = 0;
    String currentState = "A";

    public HaltingProblem(String input) {
        toStates(input);
    }

    public long calculate() {
        IntStream.range(0, number).forEach(i -> execute(states.get(currentState)));
        return tape.values().stream().filter(i -> i.equals(Integer.valueOf(1))).count();
    }

    private void execute(State state) {
        Integer currentValue = getCurrentValue(currentTapePos);
        Execution execution = state.getExecution(currentValue);
        tape.put(currentTapePos, execution.getWrite());
        if (execution.getMove().equals("right")) {
            currentTapePos = currentTapePos.intValue() + 1;
        } else {
            currentTapePos = currentTapePos.intValue() - 1;
        }
        currentState = execution.getContinueWithState();
    }

    private Integer getCurrentValue(Integer currentTapePos2) {
        Integer i = tape.get(currentTapePos2);
        if (i == null) {
            return Integer.valueOf(0);
        }
        return i;
    }

    private void toStates(String input) {
        ArrayList<String> split = split(input, "\n");
        State state = null;
        Execution execution = null;

        for (String s : split) {
            if (s.trim().startsWith("Perform")) {
                String s2 = s.trim();
                number = split(s2, " ").stream().filter(s3 -> Ints.tryParse(s3) != null).map(s3 -> Integer.valueOf(s3)).findFirst().get().intValue();
            }
            if (s.trim().startsWith("In")) {
                state = new State();
                states.put(s.substring(s.length() - 2, s.length() - 1), state);
            }
            if (s.trim().startsWith("If")) {
                execution = new Execution();
                state.setExecution(Integer.valueOf(s.substring(s.length() - 2, s.length() - 1)), execution);
            }
            if (s.trim().startsWith("- Write")) {
                execution.setWrite(Integer.valueOf(s.substring(s.length() - 2, s.length() - 1)));
            }
            if (s.trim().startsWith("- Move")) {
                execution.setMove(s.substring(s.lastIndexOf(" ") + 1, s.length() - 1));
            }
            if (s.trim().startsWith("- Continue")) {
                execution.setContinueWithState(s.substring(s.length() - 2, s.length() - 1));
            }
        }

    }

    private static ArrayList<String> split(String in, String splitString) {
        Iterable<String> split = Splitter.on(splitString)
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        return newArrayList;
    }
}

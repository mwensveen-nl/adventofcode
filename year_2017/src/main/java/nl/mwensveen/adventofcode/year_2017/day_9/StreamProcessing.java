package nl.mwensveen.adventofcode.year_2017.day_9;

import java.util.stream.Stream;

public class StreamProcessing {

    private String input;

    public StreamProcessing(String stream) {
        this.input = stream;
    }

    public int calculate() {
        Stream<Character> sch = input.chars().mapToObj(i -> (char) i);
        State state = new State();
        sch.filter(c -> {
            return cancelFilter(state, c);
        }).filter(c -> garbageFilter(state, c)).forEach(c -> calculateScore(state, c));
        ;
        return state.totalScore;
    }

    public int calculateCharsInGarbage() {
        Stream<Character> sch = input.chars().mapToObj(i -> (char) i);
        State state = new State();
        sch.filter(c -> {
            return cancelFilter(state, c);
        }).forEach(c -> calculateGarbage(state, c));
        ;
        return state.totalScore;
    }

    private void calculateGarbage(State state, Character c) {
        if (state.garbage && c == '>') {
            state.garbage = false;
        }
        if (state.garbage) {
            state.totalScore++;
        }
        if (c == '<') {
            state.garbage = true;
        }
    }

    private void calculateScore(State state, Character c) {
        if (c == '{') {
            state.groupScore++;
        }
        if (c == '}') {
            state.totalScore += state.groupScore;
            state.groupScore--;
        }
    }

    private boolean garbageFilter(State state, Character c) {
        if (state.garbage && c == '>') {
            state.garbage = false;
            return false;
        }
        if (state.garbage) {
            return false;
        }
        if (c == '<') {
            state.garbage = true;
            return false;
        }
        return true;
    }

    private boolean cancelFilter(State state, char c) {
        if (state.cancel == true) {
            state.cancel = false;
            return false;
        }
        if ('!' == c) {
            state.cancel = true;
            return false;
        }
        return true;
    }

    private static class State {
        boolean cancel = false;
        boolean garbage = false;
        int totalScore = 0;
        int groupScore = 0;

    }
}

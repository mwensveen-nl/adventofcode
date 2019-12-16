package nl.mwensveen.adventofcode.year_2019.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PhaseApplierTest {

    @Test
    public void testApplyPhases1() throws Exception {
        PhaseApplier phaseApplier = new PhaseApplier(4);
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> output = phaseApplier.applyPhases(input);

        assertEquals(0, output.get(0).intValue());
        assertEquals(1, output.get(1).intValue());
        assertEquals(0, output.get(2).intValue());
        assertEquals(2, output.get(3).intValue());
        assertEquals(9, output.get(4).intValue());
        assertEquals(4, output.get(5).intValue());
        assertEquals(9, output.get(6).intValue());
        assertEquals(8, output.get(7).intValue());
    }

    @Test
    public void testApplyPhases2() throws Exception {
        PhaseApplier phaseApplier = new PhaseApplier(100);
        List<Integer> input = Arrays.asList(8, 0, 8, 7, 1, 2, 2, 4, 5, 8, 5, 9, 1, 4, 5, 4, 6, 6, 1, 9, 0, 8, 3, 2, 1, 8, 6, 4, 5, 5, 9, 5);
        List<Integer> output = phaseApplier.applyPhases(input);

        assertEquals(2, output.get(0).intValue());
        assertEquals(4, output.get(1).intValue());
        assertEquals(1, output.get(2).intValue());
        assertEquals(7, output.get(3).intValue());
        assertEquals(6, output.get(4).intValue());
        assertEquals(1, output.get(5).intValue());
        assertEquals(7, output.get(6).intValue());
        assertEquals(6, output.get(7).intValue());
    }

    public void testApplyPhases3() throws Exception {
        PhaseApplier phaseApplier = new PhaseApplier(100);
        List<Integer> input = Arrays.asList(1, 9, 6, 1, 7, 8, 0, 4, 2, 0, 7, 2, 0, 2, 2, 0, 9, 1, 4, 4, 9, 1, 6, 0, 4, 4, 1, 8, 9, 9, 1, 7);
        List<Integer> output = phaseApplier.applyPhases(input);

        assertEquals(7, output.get(0).intValue());
        assertEquals(3, output.get(1).intValue());
        assertEquals(7, output.get(2).intValue());
        assertEquals(4, output.get(3).intValue());
        assertEquals(5, output.get(4).intValue());
        assertEquals(4, output.get(5).intValue());
        assertEquals(1, output.get(6).intValue());
        assertEquals(8, output.get(7).intValue());
    }

    public void testApplyPhases4() throws Exception {
        PhaseApplier phaseApplier = new PhaseApplier(100);
        List<Integer> input = Arrays.asList(6, 9, 3, 1, 7, 1, 6, 3, 4, 9, 2, 9, 4, 8, 6, 0, 6, 3, 3, 5, 9, 9, 5, 9, 2, 4, 3, 1, 9, 8, 7, 3);
        List<Integer> output = phaseApplier.applyPhases(input);

        assertEquals(5, output.get(0).intValue());
        assertEquals(2, output.get(1).intValue());
        assertEquals(4, output.get(2).intValue());
        assertEquals(3, output.get(3).intValue());
        assertEquals(2, output.get(4).intValue());
        assertEquals(1, output.get(5).intValue());
        assertEquals(3, output.get(6).intValue());
        assertEquals(3, output.get(7).intValue());
    }

    @Test
    public void testApplyPhases5() throws Exception {
        PhaseApplier phaseApplier = new PhaseApplier(100);

        List<Integer> input = Arrays.asList(0, 3, 0, 3, 6, 7, 3, 2, 5, 7, 7, 2, 1, 2, 9, 4, 4, 0, 6, 3, 4, 9, 1, 5, 6, 5, 4, 7, 4, 6, 6, 4);
        List<Integer> inputRepeated = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            inputRepeated.addAll(input);
        }
        List<Integer> output = phaseApplier.applyPhases(inputRepeated);

        assertEquals(8, output.get(0 + 303673).intValue());
        assertEquals(4, output.get(1 + 303673).intValue());
        assertEquals(4, output.get(2 + 303673).intValue());
        assertEquals(6, output.get(3 + 303673).intValue());
        assertEquals(2, output.get(4 + 303673).intValue());
        assertEquals(0, output.get(5 + 303673).intValue());
        assertEquals(2, output.get(6 + 303673).intValue());
        assertEquals(6, output.get(7 + 303673).intValue());
    }
}

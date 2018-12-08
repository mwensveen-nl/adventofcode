package nl.mwensveen.adventofcode.year_2018.day_7;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class StepOrdererTest {

    @Test
    public void testDetermineOrder() throws Exception {
        List<String> input = Arrays.asList("Step C must be finished before step A can begin.", "Step C must be finished before step F can begin.",
                "Step A must be finished before step B can begin.", "Step A must be finished before step D can begin.",
                "Step B must be finished before step E can begin.", "Step D must be finished before step E can begin.",
                "Step F must be finished before step E can begin.");
        StepOrderer stepOrderer = new StepOrderer(input);
        Assert.assertEquals("CABDFE", stepOrderer.determineOrder());
    }

    @Test
    public void testDetermineOrderWithExecutionTime() throws Exception {
        List<String> input = Arrays.asList("Step C must be finished before step A can begin.", "Step C must be finished before step F can begin.",
                "Step A must be finished before step B can begin.", "Step A must be finished before step D can begin.",
                "Step B must be finished before step E can begin.", "Step D must be finished before step E can begin.",
                "Step F must be finished before step E can begin.");
        StepOrderer stepOrderer = new StepOrderer(input);
        Assert.assertEquals(15, stepOrderer.determineOrderWithExecutionTime(0, 2));
    }

}

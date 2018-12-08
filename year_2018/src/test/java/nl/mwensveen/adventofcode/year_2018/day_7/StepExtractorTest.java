package nl.mwensveen.adventofcode.year_2018.day_7;

import org.junit.Assert;
import org.junit.Test;

public class StepExtractorTest {

    @Test
    public void testExtract() throws Exception {
        String input = "Step C must be finished before step A can begin.";
        StepExtractor extractor = new StepExtractor(input);
        Assert.assertEquals("C", extractor.getBefore());
        Assert.assertEquals("A", extractor.getAfter());
    }

}

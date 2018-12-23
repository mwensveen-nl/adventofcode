package nl.mwensveen.adventofcode.year_2018.day_16;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class OpCodeExecuterTest {

    @Test
    public void testFind3OrMore() throws Exception {
        List<String> input = Arrays.asList("Before: [3, 2, 1, 1]", "9 2 1 2", "After:  [3, 2, 2, 1]", "");
        OpCodeExecuter opCodeExecuter = new OpCodeExecuter(input);
        Assert.assertEquals(1, opCodeExecuter.find3OrMore());
    }

}

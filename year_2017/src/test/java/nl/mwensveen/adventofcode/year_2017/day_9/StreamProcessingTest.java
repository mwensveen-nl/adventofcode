package nl.mwensveen.adventofcode.year_2017.day_9;

import org.junit.Assert;
import org.junit.Test;

public class StreamProcessingTest {
    @Test
    public void testOne() {
        StreamProcessing streamProcessing = new StreamProcessing("{}");
        Assert.assertEquals(1, streamProcessing.calculate());
    }

    @Test
    public void testTwo() {
        StreamProcessing streamProcessing = new StreamProcessing("{{{}}}");
        Assert.assertEquals(6, streamProcessing.calculate());
    }

    @Test
    public void testThree() {
        StreamProcessing streamProcessing = new StreamProcessing("{{},{}}");
        Assert.assertEquals(5, streamProcessing.calculate());
    }

    @Test
    public void testFour() {
        StreamProcessing streamProcessing = new StreamProcessing("{{{},{},{{}}}}");
        Assert.assertEquals(16, streamProcessing.calculate());
    }

    @Test
    public void testFive() {
        StreamProcessing streamProcessing = new StreamProcessing("{<a>,<a>,<a>,<a>}");
        Assert.assertEquals(1, streamProcessing.calculate());
    }

    @Test
    public void testSix() {
        StreamProcessing streamProcessing = new StreamProcessing("{{<ab>},{<ab>},{<ab>},{<ab>}}");
        Assert.assertEquals(9, streamProcessing.calculate());
    }

    @Test
    public void testSeven() {
        StreamProcessing streamProcessing = new StreamProcessing("{{<!!>},{<!!>},{<!!>},{<!!>}}");
        Assert.assertEquals(9, streamProcessing.calculate());
    }

    @Test
    public void testEight() {
        StreamProcessing streamProcessing = new StreamProcessing("{{<a!>},{<a!>},{<a!>},{<ab>}}");
        Assert.assertEquals(3, streamProcessing.calculate());
    }

    @Test
    public void testCharsInGargageOne() {
        StreamProcessing streamProcessing = new StreamProcessing("<>");
        Assert.assertEquals(0, streamProcessing.calculateCharsInGarbage());
    }

    @Test
    public void testCharsInGargageTwo() {
        StreamProcessing streamProcessing = new StreamProcessing("<random characters>");
        Assert.assertEquals(17, streamProcessing.calculateCharsInGarbage());
    }

    @Test
    public void testCharsInGargageThree() {
        StreamProcessing streamProcessing = new StreamProcessing("<<<<>");
        Assert.assertEquals(3, streamProcessing.calculateCharsInGarbage());
    }

    @Test
    public void testCharsInGargageFour() {
        StreamProcessing streamProcessing = new StreamProcessing("<{!>}>");
        Assert.assertEquals(2, streamProcessing.calculateCharsInGarbage());
    }

    @Test
    public void testCharsInGargageFive() {
        StreamProcessing streamProcessing = new StreamProcessing("<!!>");
        Assert.assertEquals(0, streamProcessing.calculateCharsInGarbage());
    }

    @Test
    public void testCharsInGargageSix() {
        StreamProcessing streamProcessing = new StreamProcessing("<!!!>>");
        Assert.assertEquals(0, streamProcessing.calculateCharsInGarbage());
    }

    @Test
    public void testCharsInGargageSeven() {
        StreamProcessing streamProcessing = new StreamProcessing("<{o\"i!a,<{i<a>");
        Assert.assertEquals(10, streamProcessing.calculateCharsInGarbage());
    }
}

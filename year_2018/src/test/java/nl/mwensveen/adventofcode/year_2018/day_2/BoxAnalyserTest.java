package nl.mwensveen.adventofcode.year_2018.day_2;

import org.junit.Assert;
import org.junit.Test;

public class BoxAnalyserTest {

    @Test
    public void testBoxAnalyserOne() throws Exception {
        BoxAnalyser analyser = new BoxAnalyser("abcdef");
        Assert.assertEquals(false, analyser.twoTimes());
        Assert.assertEquals(false, analyser.threeTimes());
    }

    @Test
    public void testBoxAnalyserTwo() throws Exception {
        BoxAnalyser analyser = new BoxAnalyser("bababc");
        Assert.assertEquals(true, analyser.twoTimes());
        Assert.assertEquals(true, analyser.threeTimes());
    }

    @Test
    public void testBoxAnalyserThree() throws Exception {
        BoxAnalyser analyser = new BoxAnalyser("abbcde");
        Assert.assertEquals(true, analyser.twoTimes());
        Assert.assertEquals(false, analyser.threeTimes());
    }

    @Test
    public void testBoxAnalyserFour() throws Exception {
        BoxAnalyser analyser = new BoxAnalyser("abcccd");
        Assert.assertEquals(false, analyser.twoTimes());
        Assert.assertEquals(true, analyser.threeTimes());
    }

    @Test
    public void testBoxAnalyserFive() throws Exception {
        BoxAnalyser analyser = new BoxAnalyser("aabcdd");
        Assert.assertEquals(true, analyser.twoTimes());
        Assert.assertEquals(false, analyser.threeTimes());
    }

    @Test
    public void testBoxAnalyserSix() throws Exception {
        BoxAnalyser analyser = new BoxAnalyser("abcdee");
        Assert.assertEquals(true, analyser.twoTimes());
        Assert.assertEquals(false, analyser.threeTimes());
    }

    @Test
    public void testBoxAnalyserSeven() throws Exception {
        BoxAnalyser analyser = new BoxAnalyser("ababab");
        Assert.assertEquals(false, analyser.twoTimes());
        Assert.assertEquals(true, analyser.threeTimes());
    }

    @Test
    public void testDiff1() {
        BoxAnalyser analyser = new BoxAnalyser("abcde");
        BoxAnalyser otherAnalyser = new BoxAnalyser("axcye");
        Assert.assertFalse(analyser.compareOneCharDifference(otherAnalyser).isPresent());
    }

    @Test
    public void testDiff2() {
        BoxAnalyser analyser = new BoxAnalyser("abcde");
        BoxAnalyser otherAnalyser = new BoxAnalyser("abcde");
        Assert.assertFalse(analyser.compareOneCharDifference(otherAnalyser).isPresent());
    }

    @Test
    public void testDiff3() {
        BoxAnalyser analyser = new BoxAnalyser("abcde");
        BoxAnalyser otherAnalyser = new BoxAnalyser("klmno");
        Assert.assertFalse(analyser.compareOneCharDifference(otherAnalyser).isPresent());
    }

    @Test
    public void testDiff4() {
        BoxAnalyser analyser = new BoxAnalyser("fghij");
        BoxAnalyser otherAnalyser = new BoxAnalyser("fguij");
        Assert.assertEquals("fgij", analyser.compareOneCharDifference(otherAnalyser).get());
    }
}

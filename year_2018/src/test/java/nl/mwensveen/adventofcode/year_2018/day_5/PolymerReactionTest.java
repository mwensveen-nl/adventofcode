package nl.mwensveen.adventofcode.year_2018.day_5;

import org.junit.Assert;
import org.junit.Test;

public class PolymerReactionTest {

    @Test
    public void testReactOne() throws Exception {
        PolymerReaction polymerReaction = new PolymerReaction("aA");
        Assert.assertEquals(0, polymerReaction.react());
    }

    @Test
    public void testReactTwo() throws Exception {
        PolymerReaction polymerReaction = new PolymerReaction("abBA");
        Assert.assertEquals(0, polymerReaction.react());
    }

    @Test
    public void testReactThree() throws Exception {
        PolymerReaction polymerReaction = new PolymerReaction("abAB");
        Assert.assertEquals(4, polymerReaction.react());
    }

    @Test
    public void testReactFour() throws Exception {
        PolymerReaction polymerReaction = new PolymerReaction("aabAAB");
        Assert.assertEquals(6, polymerReaction.react());
    }

    @Test
    public void testReactFive() throws Exception {
        PolymerReaction polymerReaction = new PolymerReaction("dabAcCaCBAcCcaDA");
        Assert.assertEquals(10, polymerReaction.react());
    }

    @Test
    public void testRemoveAndReact() throws Exception {
        PolymerReaction polymerReaction = new PolymerReaction("dabAcCaCBAcCcaDA");
        Assert.assertEquals(4, polymerReaction.removeAndReact());
    }

    @Test
    public void testReactAndRemoveAndReact() throws Exception {
        PolymerReaction polymerReaction = new PolymerReaction("dabAcCaCBAcCcaDA");
        Assert.assertEquals(10, polymerReaction.react());
        Assert.assertEquals(4, polymerReaction.removeAndReact());
    }

}

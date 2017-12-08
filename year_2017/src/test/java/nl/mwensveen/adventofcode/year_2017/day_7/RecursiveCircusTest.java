package nl.mwensveen.adventofcode.year_2017.day_7;

import org.junit.Assert;
import org.junit.Test;

public class RecursiveCircusTest {

    // @Test
    public void testOne() {
        RecursiveCircus recursiveCircus = new RecursiveCircus("pbga (66)\n" +
                "xhth (57)\n" +
                "ebii (61)\n" +
                "havc (66)\n" +
                "ktlj (57)\n" +
                "fwft (72) -> ktlj cntj xhth\n" +
                "qoyq (66)\n" +
                "padx (45) -> pbga havc qoyq\n" +
                "tknk (41) -> ugml padx fwft\n" +
                "jptl (61)\n" +
                "ugml (68) -> gyxo ebii jptl\n" +
                "gyxo (61)\n" +
                "cntj (57)");
        Assert.assertEquals("tknk", recursiveCircus.calculate());
    }

    @Test
    public void testTwo() {
        RecursiveCircus recursiveCircus = new RecursiveCircus("pbga (66)\n" +
                "xhth (57)\n" +
                "ebii (61)\n" +
                "havc (66)\n" +
                "ktlj (57)\n" +
                "fwft (72) -> ktlj cntj xhth\n" +
                "qoyq (66)\n" +
                "padx (45) -> pbga havc qoyq\n" +
                "tknk (41) -> ugml padx fwft\n" +
                "jptl (61)\n" +
                "ugml (68) -> gyxo ebii jptl\n" +
                "gyxo (61)\n" +
                "cntj (57)");
        Assert.assertEquals(0, recursiveCircus.calculateNewWeight());
    }
}

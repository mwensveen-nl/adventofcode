package nl.mwensveen.adventofcode.year_2018.day_13;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TrainsPlayingTest {

    @Test
    public void testFindCollision() throws Exception {
        List<String> input = Arrays.asList("/->-\\        ", "|   |  /----\\", "| /-+--+-\\  |", "| | |  | v  |", "\\-+-/  \\-+--/", "  \\------/   ");
        TrainsPlaying playing = new TrainsPlaying(input);
        Assert.assertEquals(new Position(7, 3), playing.findCollision());
    }

    @Test
    public void testFindNonCollisionTrain() throws Exception {
        List<String> input = Arrays.asList("/>-<\\  ", "|   |  ", "| /<+-\\", "| | | v", "\\>+</ |", "  |   ^", "  \\<->/");
        TrainsPlaying playing = new TrainsPlaying(input);
        Assert.assertEquals(new Position(6, 4), playing.findNonCollisionTrain());
    }

}

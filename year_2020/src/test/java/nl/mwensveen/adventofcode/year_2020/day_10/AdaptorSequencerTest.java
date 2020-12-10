package nl.mwensveen.adventofcode.year_2020.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AdaptorSequencerTest {

    @Test
    public void testDetermineSequenceJoltageRatings() throws Exception {
        List<Long> input = Arrays.asList(16L, 10L, 15L, 5L, 1L, 11L, 7L, 19L, 6L, 12L, 4L);
        AdaptorSequencer sequencer = new AdaptorSequencer();
        assertEquals(35, sequencer.determineSequenceJoltageRatings(input));
    }

    @Test
    public void testDetermineSequenceJoltageRatings2() throws Exception {
        List<Long> input = Arrays.asList(28L, 33L, 18L, 42L, 31L, 14L, 46L, 20L, 48L, 47L, 24L, 23L, 49L, 45L, 19L, 38L, 39L, 11L, 1L, 32L, 25L, 35L, 8L, 17L,
                7L, 9L, 4L, 2L, 34L, 10L, 3L);
        AdaptorSequencer sequencer = new AdaptorSequencer();
        assertEquals(220, sequencer.determineSequenceJoltageRatings(input));
    }

    @Test
    public void testDetermineDistinctWays() throws Exception {
        List<Long> input = Arrays.asList(16L, 10L, 15L, 5L, 1L, 11L, 7L, 19L, 6L, 12L, 4L);
        AdaptorSequencer sequencer = new AdaptorSequencer();
        assertEquals(8, sequencer.determineDistinctWays(input));
    }

    @Test
    public void testDetermineDistinctWays2() throws Exception {
        List<Long> input = Arrays.asList(28L, 33L, 18L, 42L, 31L, 14L, 46L, 20L, 48L, 47L, 24L, 23L, 49L, 45L, 19L, 38L, 39L, 11L, 1L, 32L, 25L, 35L, 8L, 17L,
                7L, 9L, 4L, 2L, 34L, 10L, 3L);
        AdaptorSequencer sequencer = new AdaptorSequencer();
        assertEquals(19208, sequencer.determineDistinctWays(input));
    }
}

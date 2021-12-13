package nl.mwensveen.adventofcode.year_2021.day_13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class TransparentPaperFolderProcessorTest {

    @Test
    public void testProcesPaper() {
        List<String> input = Arrays.asList("6,10",
                "0,14",
                "9,10",
                "0,3",
                "10,4",
                "4,11",
                "6,0",
                "6,12",
                "4,1",
                "0,13",
                "10,12",
                "3,4",
                "3,0",
                "8,4",
                "1,10",
                "2,14",
                "8,10",
                "9,0",
                "",
                "fold along y=7",
                "fold along x=5");
        TransparentPaperFolderProcessor processor = new TransparentPaperFolderProcessor();
        int result = processor.procesPaper(input, Optional.of(1));
        assertEquals(17, result);
    }

}

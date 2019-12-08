package nl.mwensveen.adventofcode.year_2019.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ImageCheckerTest {

    @Test
    public void testCheckImage() throws Exception {
        String input = "120122709012120406700012";
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            ints.add(Integer.parseInt(input.substring(i, i + 1)));
        }

        ImageDecoder decoder = new ImageDecoder();
        Image image = decoder.decodeImage(ints, 3, 2);

        ImageChecker checker = new ImageChecker();
        int i = checker.checkImage(image);
        assertEquals(6, i);
    }

}

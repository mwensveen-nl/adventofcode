package nl.mwensveen.adventofcode.year_2018.day_18;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class LumberSolution {
    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day18.txt");
        List<String> input = Files.readLines(new File(url.getFile()), Charset.defaultCharset());
        LumberCollection lumberCollection = new LumberCollection(input);
        System.out.println("Result after 10 minutes of change magic = " + lumberCollection.performMagicChanges(10));

        // repeat every 28 minutes from minute 430
        // 1000000000 % 28 = 20.
        // 430 + 20 = 450
        // long request = 1000000000;
        int request = 1000000000;
        int i = (request - 430) % 28;
        int sameAs = 430 + i;
        lumberCollection = new LumberCollection(input);
        System.out.println("Result after 1000000000 minutes (same as " + sameAs + "minutes) of change magic = " + lumberCollection.performMagicChanges(sameAs));

    }
}

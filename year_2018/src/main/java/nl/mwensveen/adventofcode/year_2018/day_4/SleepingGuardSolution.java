package nl.mwensveen.adventofcode.year_2018.day_4;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class SleepingGuardSolution {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day4.txt");
        List<String> lines = Files.readLines(new File(url.getFile()), Charset.defaultCharset());
        SleepingGuardExtractor extractor = new SleepingGuardExtractor(lines);
        System.out.println("Result of solution 1 = " + extractor.strategyOne());
        System.out.println("Result of solution 2 = " + extractor.strategyTwo());
    }

}

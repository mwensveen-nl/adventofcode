package nl.mwensveen.adventofcode.year_2018.day_2;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class BoxIdCheckingSolution {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url = Resources.getResource("Day2.txt");
        List<String> lines = Files.readLines(new File(url.getFile()), Charset.defaultCharset());

        ChecksumCalculator calculator = new ChecksumCalculator(lines);
        System.out.println("Checksum = " + calculator.calculate());

        ExactlyOneCharDiffFinder finder = new ExactlyOneCharDiffFinder(lines);
        System.out.println("Common Letters = " + finder.find());
    }
}

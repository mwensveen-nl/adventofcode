package nl.mwensveen.adventofcode.year_2018.day_10;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class MessageSolution {
    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day10.txt");
        List<String> input = Files.readLines(new File(url.getFile()), Charset.defaultCharset());

        MessageCalculator messageCalculator = new MessageCalculator(input);
        System.out.println("Number of seconds " + messageCalculator.makeMessage());

    }
}

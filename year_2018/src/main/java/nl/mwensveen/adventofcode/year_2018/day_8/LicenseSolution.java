package nl.mwensveen.adventofcode.year_2018.day_8;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class LicenseSolution {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day8.txt");
        String input = Files.readFirstLine(new File(url.getFile()), Charset.defaultCharset());
        NodeCalculator nodeCalculator = new NodeCalculator(input);

        System.out.println("Simple Sum of metadata entries: " + nodeCalculator.calculate());
        System.out.println("Comples Sum of metadata entries: " + nodeCalculator.calculateComplex());
    }

}

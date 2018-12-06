package nl.mwensveen.adventofcode.year_2018.day_6;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class ManhathanDistanceSolution {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day6.txt");
        List<String> lines = Files.readLines(new File(url.getFile()), Charset.defaultCharset());

        ManhathanDistanceCalculator manhathanDistanceCalculator = new ManhathanDistanceCalculator(lines);
        System.out.println("Largest area = " + manhathanDistanceCalculator.calculateLargestArea());
        System.out.println("Region= " + manhathanDistanceCalculator.calculateRegion(10000));
    }

}

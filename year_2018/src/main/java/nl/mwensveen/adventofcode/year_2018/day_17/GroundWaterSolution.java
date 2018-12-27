package nl.mwensveen.adventofcode.year_2018.day_17;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class GroundWaterSolution {
    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day17.txt");
        List<String> input = Files.readLines(new File(url.getFile()), Charset.defaultCharset());

        GroundWater groundWater = new GroundWater(input);
        System.out.println("Number of tiles the water can reach: " + groundWater.flowWater());
        System.out.println("Number of tiles retaining the water : " + groundWater.OnlyWater());

    }
}

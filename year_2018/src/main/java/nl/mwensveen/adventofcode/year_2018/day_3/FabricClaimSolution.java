package nl.mwensveen.adventofcode.year_2018.day_3;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class FabricClaimSolution {

    public static void main(String[] args) throws IOException {
        Instant start = Instant.now();

        URL url = Resources.getResource("Day3.txt");
        List<String> lines = Files.readLines(new File(url.getFile()), Charset.defaultCharset());

        FabricClaimAnalyser analyser = new FabricClaimAnalyser(lines);

        System.out.println("Overlapping squares: " + analyser.calculateOverlap());
        System.out.println(Duration.between(start, Instant.now()).toMillis());
        System.out.println("Claim without overlap: " + analyser.findClaimWithoutOverlap());
        System.out.println(Duration.between(start, Instant.now()).toMillis());

    }

}

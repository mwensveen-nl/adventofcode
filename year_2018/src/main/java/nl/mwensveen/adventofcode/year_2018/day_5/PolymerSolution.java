package nl.mwensveen.adventofcode.year_2018.day_5;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class PolymerSolution {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day5.txt");
        String line = Files.readFirstLine(new File(url.getFile()), Charset.defaultCharset());
        PolymerReaction polymerReaction = new PolymerReaction(line);
        System.out.println("Length after reaction: " + polymerReaction.react());
        System.out.println("Length after remove and reaction: " + polymerReaction.removeAndReact());
    }

}

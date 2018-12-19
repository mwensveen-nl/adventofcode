package nl.mwensveen.adventofcode.year_2018.day_13;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class TrainSolution {
    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day13.txt");
        List<String> input = Files.readLines(new File(url.getFile()), Charset.defaultCharset());

        TrainsPlaying playing = new TrainsPlaying(input);
        System.out.println("First Collision at " + playing.findCollision());

        playing = new TrainsPlaying(input);
        System.out.println("Last not colliding train at " + playing.findNonCollisionTrain());

    }
}

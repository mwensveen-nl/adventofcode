package nl.mwensveen.adventofcode.year_2018.day_7;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class StepSolution {

    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day7.txt");
        List<String> input = Files.readLines(new File(url.getFile()), Charset.defaultCharset());

        StepOrderer stepOrderer = new StepOrderer(input);
        System.out.println("Order of steps: " + stepOrderer.determineOrder());

        stepOrderer = new StepOrderer(input);
        System.out.println("Time with workers: " + stepOrderer.determineOrderWithExecutionTime(60, 5));
    }

}

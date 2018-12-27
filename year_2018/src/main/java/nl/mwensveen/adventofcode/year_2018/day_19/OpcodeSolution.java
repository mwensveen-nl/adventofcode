package nl.mwensveen.adventofcode.year_2018.day_19;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class OpcodeSolution {
    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day19.txt");
        List<String> input = Files.readLines(new File(url.getFile()), Charset.defaultCharset());

        OpCodeWithProgramPointerExecuter executer = new OpCodeWithProgramPointerExecuter("#ip 2", input);
        System.out.println("Value of register 0: " + executer.executeInstructions(0));

        executer = new OpCodeWithProgramPointerExecuter("#ip 2", input);
        System.out.println("Value of register 0: " + executer.executeInstructions(1));
    }
}

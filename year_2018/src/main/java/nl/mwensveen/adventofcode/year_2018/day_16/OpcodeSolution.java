package nl.mwensveen.adventofcode.year_2018.day_16;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class OpcodeSolution {
    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day16_1.txt");
        List<String> input = Files.readLines(new File(url.getFile()), Charset.defaultCharset());

        OpCodeExecuter opCodeExecuter = new OpCodeExecuter(input);
        System.out.println("number of samples: " + opCodeExecuter.find3OrMore());

        url = Resources.getResource("Day16_2.txt");
        List<String> input2 = Files.readLines(new File(url.getFile()), Charset.defaultCharset());
        opCodeExecuter = new OpCodeExecuter(input);
        System.out.println("register 0 = " + opCodeExecuter.findRegister0(input2));
    }
}

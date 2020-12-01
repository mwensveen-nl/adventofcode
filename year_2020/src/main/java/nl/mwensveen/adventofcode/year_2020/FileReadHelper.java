package nl.mwensveen.adventofcode.year_2020;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

public final class FileReadHelper {

    public static List<Integer> readLinesAsIntegers(String fileName) {
        URL url = Resources.getResource(fileName);
        List<String> lines;
        try {
            lines = Files.readLines(new File(url.getFile()), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
    }

}

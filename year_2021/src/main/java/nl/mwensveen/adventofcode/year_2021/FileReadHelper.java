package nl.mwensveen.adventofcode.year_2021;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class FileReadHelper {

    /**
     * Read lines of the file and return each line as integer.
     *
     * @param fileName the file name
     * @return an immutable list
     */
    public static List<Integer> readLinesAsIntegers(String fileName) {
        URL url = Resources.getResource(fileName);
        List<String> lines;
        try {
            lines = Files.readLines(new File(url.getFile()), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines.stream().map(s -> Integer.valueOf(s)).collect(ImmutableList.toImmutableList());
    }

    /**
     * Read lines of the file and return each line as integer.
     *
     * @param fileName the file name
     * @return an immutable list
     */
    public static List<Long> readLinesAsLongs(String fileName) {
        URL url = Resources.getResource(fileName);
        List<String> lines;
        try {
            lines = Files.readLines(new File(url.getFile()), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines.stream().map(s -> Long.valueOf(s)).collect(ImmutableList.toImmutableList());
    }

    /**
     * Read lines of the file and return each line as String.
     *
     * @param fileName the file name
     * @return an immutable list
     */
    public static List<String> readLinesAsStrings(String fileName) {
        URL url = Resources.getResource(fileName);
        List<String> lines;
        try {
            lines = Files.readLines(new File(url.getFile()), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ImmutableList.copyOf(lines);
    }

}

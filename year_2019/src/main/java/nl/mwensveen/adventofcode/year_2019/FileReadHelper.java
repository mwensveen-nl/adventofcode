package nl.mwensveen.adventofcode.year_2019;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class FileReadHelper {

    public static List<String> readLines(String fileName) {
        URL url = Resources.getResource(fileName);
        List<String> lines;
        try {
            lines = Files.readLines(new File(url.getFile()), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static List<Integer> readCSVIntegers(String fileName) {

        URL url = Resources.getResource(fileName);
        String line;
        try {
            line = Files.asCharSource(new File(url.getFile()), Charset.defaultCharset()).readFirstLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Stream.of(line.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static List<BigInteger> readCSVBigIntegers(String fileName) {

        URL url = Resources.getResource(fileName);
        String line;
        try {
            line = Files.asCharSource(new File(url.getFile()), Charset.defaultCharset()).readFirstLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Stream.of(line.split(",")).map(s -> new BigInteger(s)).collect(Collectors.toList());
    }

    public static String readString(String fileName) {

        URL url = Resources.getResource(fileName);
        String all;
        try {
            all = Files.asCharSource(new File(url.getFile()), Charset.defaultCharset()).read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return all;
    }

    public static List<Integer> readStringAsIntegers(String fileName) {
        URL url = Resources.getResource(fileName);
        List<Integer> ints = new ArrayList<>();
        try {
            String all = Files.asCharSource(new File(url.getFile()), Charset.defaultCharset()).read();
            for (int i = 0; i < all.length(); i++) {
                ints.add(Integer.parseInt(all.substring(i, i + 1)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ints;
    }

}

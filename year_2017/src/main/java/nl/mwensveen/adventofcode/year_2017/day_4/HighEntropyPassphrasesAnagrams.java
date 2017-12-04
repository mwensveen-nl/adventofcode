package nl.mwensveen.adventofcode.year_2017.day_4;

import com.google.common.base.Splitter;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class HighEntropyPassphrasesAnagrams {

    private List<String> lines;

    public HighEntropyPassphrasesAnagrams(File file) throws IOException {
        lines = Files.readLines(file, Charset.defaultCharset());
    }

    public Long calculate() {
        return lines.stream().filter(l -> check(l)).collect(Collectors.counting());
    }

    private boolean check(String passphrase) {
        Iterable<String> split = Splitter.on(" ")
            .trimResults()
            .omitEmptyStrings()
            .split(passphrase);
        long count = StreamSupport.stream(split.spliterator(), false).count();
        long countDistict = StreamSupport.stream(split.spliterator(), false).map(word -> orderString(word)).distinct().count();
        return count == countDistict;
    }

    private String orderString(String word) {
        return IntStream.range(0, word.length()).mapToObj(i -> word.substring(i, i + 1)).sorted().collect(Collectors.joining());
    }
}

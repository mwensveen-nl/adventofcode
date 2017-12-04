package nl.mwensveen.adventofcode.year_2017.day_4;

import com.google.common.base.Splitter;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class HighEntropyPassphrases {

    private List<String> lines;

    public HighEntropyPassphrases(File file) throws IOException {
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
        long countDistict = StreamSupport.stream(split.spliterator(), false).distinct().count();
        return count == countDistict;
    }
}

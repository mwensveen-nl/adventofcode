package nl.mwensveen.adventofcode.year_2017.day_4;

import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class HighEntropyPassphrasesSolution {
    public static void main(String[] args) throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("Solution.txt").toURI());
        HighEntropyPassphrases highEntropyPassphrases = new HighEntropyPassphrases(f);
        System.out.println("part 1 result: " + highEntropyPassphrases.calculate());
        HighEntropyPassphrasesAnagrams highEntropyPassphrasesAnagrams = new HighEntropyPassphrasesAnagrams(f);
        System.out.println("part 2 result: " + highEntropyPassphrasesAnagrams.calculate());
    }
}

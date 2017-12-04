package nl.mwensveen.adventofcode.year_2017.day_4;

import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Assert;
import org.junit.Test;

public class HighEntropyPassphrasesAnagramsTest {
    @Test
    public void testOne() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesTestOne.txt").toURI());
        HighEntropyPassphrasesAnagrams highEntropyPassphrases = new HighEntropyPassphrasesAnagrams(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(1), correctLines);
    }

    @Test
    public void testTwo() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesTestTwo.txt").toURI());
        HighEntropyPassphrasesAnagrams highEntropyPassphrases = new HighEntropyPassphrasesAnagrams(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(0), correctLines);
    }

    @Test
    public void testThree() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesAnagramsTestThree.txt").toURI());
        HighEntropyPassphrasesAnagrams highEntropyPassphrases = new HighEntropyPassphrasesAnagrams(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(1), correctLines);
    }

    @Test
    public void testFour() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesAnagramsTestFour.txt").toURI());
        HighEntropyPassphrasesAnagrams highEntropyPassphrases = new HighEntropyPassphrasesAnagrams(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(0), correctLines);
    }

    @Test
    public void testFive() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesAnagramsTestFive.txt").toURI());
        HighEntropyPassphrasesAnagrams highEntropyPassphrases = new HighEntropyPassphrasesAnagrams(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(1), correctLines);
    }

    @Test
    public void testSix() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesAnagramsTestSeven.txt").toURI());
        HighEntropyPassphrasesAnagrams highEntropyPassphrases = new HighEntropyPassphrasesAnagrams(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(0), correctLines);
    }

}

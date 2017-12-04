package nl.mwensveen.adventofcode.year_2017.day_4;

import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Assert;
import org.junit.Test;

public class HighEntropyPassphrasesTest {

    @Test
    public void testOne() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesTestOne.txt").toURI());
        HighEntropyPassphrases highEntropyPassphrases = new HighEntropyPassphrases(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(1), correctLines);
    }

    @Test
    public void testTwo() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesTestTwo.txt").toURI());
        HighEntropyPassphrases highEntropyPassphrases = new HighEntropyPassphrases(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(0), correctLines);
    }

    @Test
    public void testThree() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesTestThree.txt").toURI());
        HighEntropyPassphrases highEntropyPassphrases = new HighEntropyPassphrases(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(1), correctLines);
    }

    @Test
    public void testFour() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesTestFour.txt").toURI());
        HighEntropyPassphrases highEntropyPassphrases = new HighEntropyPassphrases(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(1), correctLines);
    }

    @Test
    public void testFive() throws URISyntaxException, IOException {
        File f = new File(Resources.getResource("HighEntropyPassphrasesTestFive.txt").toURI());
        HighEntropyPassphrases highEntropyPassphrases = new HighEntropyPassphrases(f);
        Long correctLines = highEntropyPassphrases.calculate();
        Assert.assertEquals(Long.valueOf(3), correctLines);
    }
}

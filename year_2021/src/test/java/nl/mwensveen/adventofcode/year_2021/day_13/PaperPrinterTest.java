package nl.mwensveen.adventofcode.year_2021.day_13;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PaperPrinterTest {

    @Test
    public void testPrintPaper() {
        List<String> input = Arrays.asList("6,10",
                "0,14",
                "9,10",
                "0,3",
                "10,4",
                "4,11",
                "6,0",
                "6,12",
                "4,1",
                "0,13",
                "10,12",
                "3,4",
                "3,0",
                "8,4",
                "1,10",
                "2,14",
                "8,10",
                "9,0",
                "",
                "fold along y=7",
                "fold along x=5");
        TransparentPaperParser transparentPaperParser = new TransparentPaperParser();
        Table<Integer, Integer, Character> paper = transparentPaperParser.parsePaper(input);

        PaperFolder paperFolder = new PaperFolder();
        Table<Integer, Integer, Character> foldPaper = paperFolder.foldPaper("fold along y=7", paper);
        foldPaper = paperFolder.foldPaper("fold along x=5", foldPaper);

        PaperPrinter paperPrinter = new PaperPrinter();
        paperPrinter.printPaper(foldPaper);
    }

}

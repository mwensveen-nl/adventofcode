package nl.mwensveen.adventofcode.year_2021.day_13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

public class PaperFolderTest {

	@Test
	public void testFoldPaper1() {
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
		assertEquals(3, paper.row(0).entrySet().size());

		PaperFolder paperFolder = new PaperFolder();
		Table<Integer, Integer, Character> foldPaper = paperFolder.foldPaper("fold along y=7", paper);
		assertEquals(5, foldPaper.row(0).entrySet().size());
		assertTrue(foldPaper.contains(0, 0));
		assertTrue(foldPaper.contains(0, 2));
		assertTrue(foldPaper.contains(0, 3));
		assertTrue(foldPaper.contains(0, 6));
		assertTrue(foldPaper.contains(0, 9));
	}

	@Test
	public void testFoldPaper2() {
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
		assertEquals(3, paper.row(0).entrySet().size());

		PaperFolder paperFolder = new PaperFolder();
		Table<Integer, Integer, Character> foldPaper = paperFolder.foldPaper("fold along y=7", paper);
		assertEquals(5, foldPaper.row(0).entrySet().size());

		foldPaper = paperFolder.foldPaper("fold along x=5", foldPaper);

		assertEquals(5, foldPaper.row(0).entrySet().size());
		assertTrue(foldPaper.contains(0, 0));
		assertTrue(foldPaper.contains(0, 1));
		assertTrue(foldPaper.contains(0, 2));
		assertTrue(foldPaper.contains(0, 3));
		assertTrue(foldPaper.contains(0, 4));
	}

}

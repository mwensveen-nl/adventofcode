package nl.mwensveen.adventofcode.year_2023;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;
import com.google.common.io.Resources;

@ParametersAreNonnullByDefault
public final class FileReadHelper {

	/**
	 * Read lines of the file and return each line as Integer.
	 *
	 * @param fileName the file name
	 * @return an immutable list
	 */
	public static List<Integer> readLinesAsIntegers(String fileName) {
		List<String> lines;
		try {
			lines = Files.readLines(asFile(fileName), Charset.defaultCharset());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return lines.stream().map(s -> Integer.valueOf(s)).collect(ImmutableList.toImmutableList());
	}

	private static File asFile(String fileName) {
		URL url = Resources.getResource(fileName);
		File file = new File(url.getFile());
		return file;
	}

	/**
	 * Read lines of the file and return each line as Long.
	 *
	 * @param fileName the file name
	 * @return an immutable list
	 */
	public static List<Long> readLinesAsLongs(String fileName) {
		List<String> lines;
		try {
			lines = Files.readLines(asFile(fileName), Charset.defaultCharset());
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
		List<String> lines;
		try {
			lines = Files.readLines(asFile(fileName), Charset.defaultCharset());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return ImmutableList.copyOf(lines);
	}

	/**
	 * Read first (and only?) line of the file and return as String.
	 *
	 * @param fileName the file name
	 * @return an immutable list
	 */
	public static String readLineAsString(String fileName) {
		String line;
		try {
			line = Files.asCharSource(asFile(fileName), Charset.defaultCharset()).readFirstLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return line;
	}

}

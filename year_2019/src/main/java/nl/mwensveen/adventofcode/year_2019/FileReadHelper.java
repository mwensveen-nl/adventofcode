package nl.mwensveen.adventofcode.year_2019;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.io.Files;
import com.google.common.io.Resources;

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
}

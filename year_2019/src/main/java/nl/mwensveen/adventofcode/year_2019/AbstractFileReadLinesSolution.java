package nl.mwensveen.adventofcode.year_2019;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.io.Files;
import com.google.common.io.Resources;

public abstract class AbstractFileReadLinesSolution {

	public static List<String> read(String fileName) {
		URL url = Resources.getResource(fileName);
		List<String> lines;
		try {
			lines = Files.readLines(new File(url.getFile()), Charset.defaultCharset());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return lines;
	}
}

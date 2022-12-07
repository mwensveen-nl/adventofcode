package nl.mwensveen.adventofcode.year_2022.day_07;

import java.util.List;

public class FileSystemCreator {

	public FileSystemOverview createFileSystem(List<String> commands) {
		FileSystemOverview fs = new FileSystemOverview();
		commands.forEach(c -> fs.processCommand(c));
		return fs;
	}
}

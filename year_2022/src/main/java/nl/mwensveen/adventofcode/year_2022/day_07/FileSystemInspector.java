package nl.mwensveen.adventofcode.year_2022.day_07;

import java.util.ArrayList;
import java.util.List;

public class FileSystemInspector {

	public Long findSizeOfDirectories(FileSystemOverview fileSystem, Long maxSize) {
		return findSizeOfDirectories(fileSystem.getRoot(), maxSize);
	}

	private Long findSizeOfDirectories(Directory directory, Long maxSize) {
		long size = 0;
		if (directory.getDirSize() <= maxSize) {
			size += directory.getDirSize();
		}

		for (Directory child : directory.getChildren()) {
			size += findSizeOfDirectories(child, maxSize);
		}

		return size;
	}

	public long findSmallestDirectoryWithSize(FileSystemOverview fileSystem, Long minSize) {
		List<Directory> dirs = findDirectorisWithSize(fileSystem.getRoot(), minSize);
		long min = dirs.stream().mapToLong(Directory::getDirSize).min().getAsLong();
		return min;
	}

	public List<Directory> findDirectorisWithSize(Directory directory, Long minSize) {
		List<Directory> possibleDirectories = new ArrayList<>();

		if (directory.getDirSize() >= minSize) {
			possibleDirectories.add(directory);
		}

		for (Directory child : directory.getChildren()) {
			possibleDirectories.addAll(findDirectorisWithSize(child, minSize));
		}
		return possibleDirectories;
	}
}

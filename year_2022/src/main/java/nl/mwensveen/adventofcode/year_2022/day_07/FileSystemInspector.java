package nl.mwensveen.adventofcode.year_2022.day_07;

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
}

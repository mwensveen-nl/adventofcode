package nl.mwensveen.adventofcode.year_2022.day_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FileSystemInspectorTest {
	private final String input = """
			$ cd /
			$ ls
			dir a
			14848514 b.txt
			8504156 c.dat
			dir d
			$ cd a
			$ ls
			dir e
			29116 f
			2557 g
			62596 h.lst
			$ cd e
			$ ls
			584 i
			$ cd ..
			$ cd ..
			$ cd d
			$ ls
			4060174 j
			8033020 d.log
			5626152 d.ext
			7214296 k
						""";

	@Test
	public void testFindSizeOfDirectoriesFileSystemOverviewLong() {
		FileSystemCreator creator = new FileSystemCreator();
		FileSystemOverview fileSystem = creator.createFileSystem(input.lines().toList());
		FileSystemInspector inspector = new FileSystemInspector();
		Long size = inspector.findSizeOfDirectories(fileSystem, 100000L);
		assertEquals(95437L, size);
	}

	@Test
	public void testFindSmallestDirectoryWithSize() {
		FileSystemCreator creator = new FileSystemCreator();
		FileSystemOverview fileSystem = creator.createFileSystem(input.lines().toList());
		FileSystemInspector inspector = new FileSystemInspector();
		Long size = inspector.findSmallestDirectoryWithSize(fileSystem, 30000000 - (70000000 - fileSystem.getRoot().getDirSize()));
		assertEquals(24933642L, size);
	}

}

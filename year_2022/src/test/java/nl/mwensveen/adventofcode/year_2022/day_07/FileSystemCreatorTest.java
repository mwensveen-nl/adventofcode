package nl.mwensveen.adventofcode.year_2022.day_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FileSystemCreatorTest {

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
	public void testCreateFileSystem() {
		FileSystemCreator creator = new FileSystemCreator();
		FileSystemOverview fileSystem = creator.createFileSystem(input.lines().toList());
		assertEquals(2, fileSystem.getRoot().getChildren().size());
		assertEquals(48381165L, fileSystem.getRoot().getDirSize());

		assertEquals(94853L, fileSystem.getRoot().toChildDir("a").getDirSize());
		assertEquals(24933642L, fileSystem.getRoot().toChildDir("d").getDirSize());

	}

}

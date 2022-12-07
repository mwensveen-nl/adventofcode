package nl.mwensveen.adventofcode.year_2022.day_07;

import java.util.List;

import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class NoSpaceLeftOnDeviceSolution extends AbstractTimedSolution {

	private static final Long DIVICE_SIZE = 70000000L;
	private static final Long UPDATE_SIZE = 30000000L;
	private List<String> input;
	private FileSystemOverview fileSystem;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("day07.txt");
		FileSystemCreator creator = new FileSystemCreator();
		fileSystem = creator.createFileSystem(input);
	}

	@Override
	protected void part1() {
		FileSystemInspector inspector = new FileSystemInspector();
		Long size = inspector.findSizeOfDirectories(fileSystem, 100000L);
		System.out.println("The sum of the total sizes of the directories with a total size of at most 100000: " + size);
	}

	@Override
	protected void part2() {
		FileSystemInspector inspector = new FileSystemInspector();
		Long requiredSize = UPDATE_SIZE - (DIVICE_SIZE - fileSystem.getRoot().getDirSize());
		Long size = inspector.findSmallestDirectoryWithSize(fileSystem, requiredSize);
		System.out
				.println("the total size of the smallest directory that, if deleted, would free up enough space on the filesystem to run the update: " + size);
	}

	public static void main(String[] args) {
		new NoSpaceLeftOnDeviceSolution().run();
	}

}

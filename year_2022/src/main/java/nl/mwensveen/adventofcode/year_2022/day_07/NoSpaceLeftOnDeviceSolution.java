package nl.mwensveen.adventofcode.year_2022.day_07;

import java.util.List;

import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class NoSpaceLeftOnDeviceSolution extends AbstractTimedSolution {

	private List<String> input;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("day07.txt");
	}

	@Override
	protected void part1() {
		FileSystemCreator creator = new FileSystemCreator();
		FileSystemOverview fileSystem = creator.createFileSystem(input);
		FileSystemInspector inspector = new FileSystemInspector();
		Long size = inspector.findSizeOfDirectories(fileSystem, 100000L);
		System.out.println("The sum of the total sizes of the directories with a total size of at most 100000: " + size);
	}

	@Override
	protected void part2() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new NoSpaceLeftOnDeviceSolution().run();
	}

}

package nl.mwensveen.adventofcode.year_2023.day_03;

import java.util.List;

import com.google.common.collect.Table;

import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class GearRatiosSolution extends AbstractTimedSolution {

	private Table<Integer, Integer, String> engineSchematic;

	@Override
	protected void init() {
		List<String> input = FileReadHelper.readLinesAsStrings("Day_03.txt");
		EngineSchematicParser schematicParser = new EngineSchematicParser();
		engineSchematic = schematicParser.parse(input);
	}

	@Override
	protected void part1() {
		PartDiscoverer partDiscoverer = new PartDiscoverer();
		List<Integer> parts = partDiscoverer.discoverParts(engineSchematic);
		Long sum = partDiscoverer.sumParts(parts);
		System.out.println("The sum of all of the part numbers in the engine schematic: " + sum);
	}

	@Override
	protected void part2() {
		GearDiscoverer gearDiscoverer = new GearDiscoverer();
		Long gearRatios = gearDiscoverer.discoverGears(engineSchematic);
		System.out.println("The sum of all of the gear ratios in your engine schematic: " + gearRatios);
	}

	public static void main(String[] args) {
		new GearRatiosSolution().run();
	}
}

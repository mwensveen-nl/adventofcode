package nl.mwensveen.adventofcode.year_2022.day_13;

import java.util.List;

import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class DistressSignalSolution extends AbstractTimedSolution {

	private List<String> input;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("day13.txt");
	}

	@Override
	protected void part1() {
		PacketsParser packetsParser = new PacketsParser();
		List<PacketPairs> packets = packetsParser.parse(input);
		PacketsAnalyser packetsAnalyser = new PacketsAnalyser();
		int sum = packetsAnalyser.analysePackets(packets);
		System.out.println("The sum of the indices of pairs of packets that are already in the right order: " + sum);

	}

	@Override
	protected void part2() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new DistressSignalSolution().run();
	}

}

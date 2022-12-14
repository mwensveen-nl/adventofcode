package nl.mwensveen.adventofcode.year_2022.day_13;

import java.util.List;
import java.util.stream.IntStream;

public class PacketsParser {

	public List<PacketPairs> parse(List<String> input) {
		return IntStream.range(0, (input.size() + 1) / 3).mapToObj(i -> new PacketPairs(i + 1, input.get(i * 3), input.get(i * 3 + 1))).toList();
	}
}

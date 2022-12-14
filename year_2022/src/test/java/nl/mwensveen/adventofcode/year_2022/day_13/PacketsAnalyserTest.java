package nl.mwensveen.adventofcode.year_2022.day_13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PacketsAnalyserTest {
	private String input = """
			[1,1,3,1,1]
			[1,1,5,1,1]

			[[1],[2,3,4]]
			[[1],4]

			[9]
			[[8,7,6]]

			[[4,4],4,4]
			[[4,4],4,4,4]

			[7,7,7,7]
			[7,7,7]

			[]
			[3]

			[[[]]]
			[[]]

			[1,[2,[3,[4,[5,6,7]]]],8,9]
			[1,[2,[3,[4,[5,6,0]]]],8,9]
						""";

	@Test
	public void testAnalysePackets() {
		PacketsParser packetsParser = new PacketsParser();
		List<PacketPairs> packets = packetsParser.parse(input.lines().toList());
		PacketsAnalyser packetsAnalyser = new PacketsAnalyser();
		int sum = packetsAnalyser.analysePackets(packets);
		assertEquals(13, sum);

	}

}

package nl.mwensveen.adventofcode.year_2022.day_13;

import java.util.List;

public class PacketsAnalyser {

	public int analysePackets(List<PacketPairs> packetPairs) {
		PacketValidator validator = new PacketValidator();
		return packetPairs.stream().filter(pp -> validator.validate(pp) == CompareResult.OK).mapToInt(PacketPairs::getNumber).sum();
	}
}

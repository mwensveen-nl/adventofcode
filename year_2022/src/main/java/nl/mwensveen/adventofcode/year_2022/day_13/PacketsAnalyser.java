package nl.mwensveen.adventofcode.year_2022.day_13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PacketsAnalyser {

    private static final String DECODER6 = "[[6]]";
    private static final String DECODER2 = "[[2]]";
    private static final List<String> DECODERS = List.of(DECODER2, DECODER6);

    public int analysePackets(List<PacketPairs> packetPairs) {
        PacketValidator validator = new PacketValidator();
        return packetPairs.stream().filter(pp -> validator.validate(pp) == CompareResult.OK).mapToInt(PacketPairs::getNumber).sum();
    }

    public int decoderFinder(List<String> input) {
        List<String> withDecoder = new ArrayList<>(input);
        withDecoder.add(DECODER2);
        withDecoder.add(DECODER6);
        List<PacketPart> sorted = withDecoder.stream().filter(s -> !s.isBlank()).map(PacketPart::new).sorted().toList();
        System.out.println(sorted);
        System.out.println(IntStream.range(0, sorted.size()).filter(i -> DECODERS.contains(sorted.get(i).getPart())).map(i -> i + 1).mapToObj(Integer::valueOf).toList());
        return IntStream.range(0, sorted.size()).filter(i -> DECODERS.contains(sorted.get(i).getPart())).map(i -> i + 1).reduce(1, (a, b) -> a * b);

    }
}

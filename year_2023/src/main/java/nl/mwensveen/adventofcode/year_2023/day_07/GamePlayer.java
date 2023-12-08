package nl.mwensveen.adventofcode.year_2023.day_07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GamePlayer {

	public long playGame(List<HandBid> hb) {
		List<HandBid> mutable = new ArrayList();
		mutable.addAll(hb);

		mutable.sort((hb1, hb2) -> Hand.compare(hb1.hand(), hb2.hand()));

		return IntStream.range(0, mutable.size()).mapToLong(i -> mutable.get(i).bid() * (i + 1)).sum();
	}

}

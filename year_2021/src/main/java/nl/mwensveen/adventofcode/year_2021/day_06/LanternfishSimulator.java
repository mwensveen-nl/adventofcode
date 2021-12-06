package nl.mwensveen.adventofcode.year_2021.day_06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LanternfishSimulator {

	public long simulate(List<Integer> input, int numberOfDays) {
		List<Lanternfish> lfs = new ArrayList<>(input.stream().map(i -> new Lanternfish(i)).toList());
		IntStream.range(0, numberOfDays).forEach(i -> {
			long newFishes = lfs.stream().filter(lf -> lf.nextDay())
					.collect(Collectors.summingLong(Lanternfish::getNumberOfFish));
			lfs.add(Lanternfish.createNewFishs(newFishes));
		});

		return lfs.stream().collect(Collectors.summingLong(Lanternfish::getNumberOfFish));
	}
}

package nl.mwensveen.adventofcode.year_2021.day_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RateCalculator {

	static enum Search {
		MIN, MAX
	}

	int calculatePowerConsumption(List<String> input) {
		List<Integer> numberOnes = new ArrayList<>();
		input.forEach(b -> processBinairy(b, numberOnes));

		String gammaRate = calculateGammaRate(numberOnes, input.size());
		String epsilonRate = calculateEpsilonRate(gammaRate);

		return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2);
	}

	int calculateLifeSupportRating(List<String> input) {
		int oxygenGeneratorRating = calculateRatingForLifeSupport(input, Search.MAX);
		int co2ScrubberRating = calculateRatingForLifeSupport(input, Search.MIN);
		return oxygenGeneratorRating * co2ScrubberRating;
	}

	private int calculateRatingForLifeSupport(List<String> input, Search search) {
		List<String> toProcess = input;
		AtomicInteger pos = new AtomicInteger();
		while (toProcess.size() > 1) {
			char mostChar = countInBinaries(toProcess, pos.get());
			char searchChar = search == Search.MAX ? mostChar : (mostChar == '1' ? '0' : '1');
			toProcess = toProcess.stream().filter(s -> s.charAt(pos.get()) == searchChar).collect(Collectors.toList());
			pos.addAndGet(1);
		}
		return Integer.parseInt(toProcess.get(0), 2);
	}

	private String calculateEpsilonRate(String gammaRate) {
		StringBuilder sb = new StringBuilder();
		gammaRate.chars().forEach(c -> {
			System.out.println(c);
			sb.append(c == '1' ? "0" : "1");
			System.out.println(sb);
		});
		return sb.toString();
	}

	private String calculateGammaRate(List<Integer> numberOnes, int size) {
		StringBuilder sb = new StringBuilder();
		numberOnes.forEach(i -> {
			sb.append(i > size - i ? "1" : "0");
		});
		return sb.toString();
	}

	private void processBinairy(String b, List<Integer> numberOnes) {
		IntStream.range(0, b.length()).forEach(i -> {
			char bit = b.charAt(i);
			if (numberOnes.size() - 1 < i) {
				numberOnes.add(Integer.valueOf(0));
			}
			if (bit == '1') {
				numberOnes.set(i, numberOnes.get(i) + 1);
			}
		});
	}

	private char countInBinaries(List<String> binaries, int pos) {
		AtomicInteger count = new AtomicInteger();
		binaries.forEach(b -> {
			char charAt = b.charAt(pos);
			if (charAt == '1') {
				count.addAndGet(1);
			}
		});
		int ones = count.get();
		int zeros = binaries.size() - ones;
		if (ones >= zeros) {
			return '1';
		} else {
			return '0';
		}
	}
}

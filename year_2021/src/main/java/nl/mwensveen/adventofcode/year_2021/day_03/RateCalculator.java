package nl.mwensveen.adventofcode.year_2021.day_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RateCalculator {

	int calculateRates(List<String> input) {
		List<Integer> numberOnes = new ArrayList<>();
		input.forEach(b -> processBinairy(b, numberOnes));

		String gammaRate = calculateGammaRate(numberOnes, input.size());
		String epsilonRate = calculateEpsilonRate(gammaRate);

		return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2);
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
}

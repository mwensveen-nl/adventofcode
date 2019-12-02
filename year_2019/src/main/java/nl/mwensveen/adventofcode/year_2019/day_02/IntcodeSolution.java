package nl.mwensveen.adventofcode.year_2019.day_02;

import java.util.List;

import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class IntcodeSolution extends AbstractTimedSolution {

	public static void main(String[] args) {
		IntcodeSolution solution = new IntcodeSolution();
		solution.run();
	}

	@Override
	protected void part1() {
		List<Integer> integers = FileReadHelper.readCSVIntegers("Day02.txt");
		integers.set(1, 12);
		integers.set(2, 2);
		IntcodeProgram intcodeProgram = new IntcodeProgram();
		Integer result = intcodeProgram.process(integers);

		System.out.println("Result of Intcode program part 1: " + result);
	}

	@Override
	protected void part2() {
		IntcodeProgram intcodeProgram = new IntcodeProgram();
		for (int noun = 0; noun <= 99; noun++) {
			for (int verb = 0; verb <= 99; verb++) {
				List<Integer> integers = FileReadHelper.readCSVIntegers("Day02.txt");
				integers.set(1, noun);
				integers.set(2, verb);
				Integer result = intcodeProgram.process(integers);
				if (result == 19690720) {
					int calc = 100 * noun + verb;
					System.out.println("noun: " + noun + " verb: " + verb);
					System.out.println("Result of Intcode program part 2: " + calc);
				}
			}
		}
	}
}

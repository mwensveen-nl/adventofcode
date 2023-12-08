package nl.mwensveen.adventofcode.year_2023.day_08;

public class LCM {
	// https://www.baeldung.com/java-least-common-multiple
	public static long lcm(long number1, long number2) {
		if (number1 == 0 || number2 == 0) {
			return 0;
		}
		long higherNumber = Math.max(number1, number2);
		long lowerNumber = Math.min(number1, number2);
		long lcm = higherNumber;
		while (lcm % lowerNumber != 0) {
			lcm += higherNumber;
		}
		return lcm;
	}
}

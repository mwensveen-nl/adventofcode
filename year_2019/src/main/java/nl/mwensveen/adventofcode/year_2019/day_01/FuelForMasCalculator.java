package nl.mwensveen.adventofcode.year_2019.day_01;

public class FuelForMasCalculator {

	static int calculate(int mass) {
		int foo = mass / 3;
		int fee = foo - 2;
		return fee;
	}

	static int calculateIncFuel(int mass) {
		int foo = calculate(mass);
		int total = 0;
		while (foo > 0) {
			total += foo;
			foo = calculate(foo);
		}
		return total;
	}
}

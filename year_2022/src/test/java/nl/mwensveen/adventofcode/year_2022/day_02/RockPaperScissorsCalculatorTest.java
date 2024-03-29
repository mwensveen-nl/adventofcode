package nl.mwensveen.adventofcode.year_2022.day_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RockPaperScissorsCalculatorTest {
	private String input = """
			A Y
			B X
			C Z
					""";
	private RockPaperScissorsCalculator calculator = new RockPaperScissorsCalculator();

	@Test
	public void testCalculateRound() {
		assertEquals(4, calculator.calculateRound(Shape.findOppponent("A"), Shape.findSelf("X")));
		assertEquals(5, calculator.calculateRound(Shape.findOppponent("B"), Shape.findSelf("Y")));
		assertEquals(6, calculator.calculateRound(Shape.findOppponent("C"), Shape.findSelf("Z")));

		assertEquals(8, calculator.calculateRound(Shape.findOppponent("A"), Shape.findSelf("Y")));
		assertEquals(9, calculator.calculateRound(Shape.findOppponent("B"), Shape.findSelf("Z")));
		assertEquals(7, calculator.calculateRound(Shape.findOppponent("C"), Shape.findSelf("X")));

		assertEquals(3, calculator.calculateRound(Shape.findOppponent("A"), Shape.findSelf("Z")));
		assertEquals(1, calculator.calculateRound(Shape.findOppponent("B"), Shape.findSelf("X")));
		assertEquals(2, calculator.calculateRound(Shape.findOppponent("C"), Shape.findSelf("Y")));
	}

	@Test
	public void testPlayTournamentTwoShapes() {
		int score = calculator.playTournamentTwoShapes(input.lines().toList());
		assertEquals(15, score);
	}

	@Test
	public void testCalculateRoundShapeResult() {
		assertEquals(3, calculator.calculateRound(Shape.findOppponent("A"), Result.find("X")));
		assertEquals(4, calculator.calculateRound(Shape.findOppponent("A"), Result.find("Y")));
		assertEquals(8, calculator.calculateRound(Shape.findOppponent("A"), Result.find("Z")));

		assertEquals(1, calculator.calculateRound(Shape.findOppponent("B"), Result.find("X")));
		assertEquals(5, calculator.calculateRound(Shape.findOppponent("B"), Result.find("Y")));
		assertEquals(9, calculator.calculateRound(Shape.findOppponent("B"), Result.find("Z")));

		assertEquals(2, calculator.calculateRound(Shape.findOppponent("C"), Result.find("X")));
		assertEquals(6, calculator.calculateRound(Shape.findOppponent("C"), Result.find("Y")));
		assertEquals(7, calculator.calculateRound(Shape.findOppponent("C"), Result.find("Z")));

	}

}

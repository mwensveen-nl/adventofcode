package nl.mwensveen.adventofcode.year_2022.day_02;

public enum Shape {

	ROCK("A", "X", 1, "C"), PAPER("B", "Y", 2, "A"), SCISSORS("C", "Z", 3, "B");

	private final String opponent;
	private final String self;
	private final int score;
	private final String winsFrom;

	Shape(String opponent, String self, int score, String winsFrom) {
		this.opponent = opponent;
		this.self = self;
		this.score = score;
		this.winsFrom = winsFrom;
	}

	public int getScore() {
		return score;
	}

	/**
	 * Score for win from opponent.
	 *
	 * @param other the opponent
	 * @return 6: win, 3: draw, 0: loss
	 */
	public int wins(Shape other) {
		if (this.equals(other)) {
			return 3; // draw
		}
		if (this.winsFrom.equals(other.opponent)) {
			return 6; // win
		}
		return 0; // loss
	}

	public static Shape findOppponent(String opponent) {
		for (Shape elem : Shape.values()) {
			if (elem.opponent.equals(opponent)) {
				return elem;
			}
		}
		throw new RuntimeException("Invalid Shape requested " + opponent);
	}

	public static Shape findSelf(String self) {
		for (Shape elem : Shape.values()) {
			if (elem.self.equals(self)) {
				return elem;
			}
		}
		throw new RuntimeException("Invalid Shape requested " + self);
	}

}

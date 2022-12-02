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
			return Result.DRAW.getScore();
		}
		if (this.winsFrom.equals(other.opponent)) {
			return Result.WIN.getScore();
		}
		return Result.LOSE.getScore();
	}

	/**
	 * Gets the shape I need to get the result against this opponent.
	 *
	 * @param r the needed Result
	 * @return the self for result
	 */
	public Shape getSelfForResult(Result r) {
		if (r.equals(Result.DRAW)) {
			return this;
		}
		if (r.equals(Result.WIN)) {
			return findWinsFrom(opponent);
		}
		return findOppponent(winsFrom);
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

	private static Shape findWinsFrom(String winsFrom) {
		for (Shape elem : Shape.values()) {
			if (elem.winsFrom.equals(winsFrom)) {
				return elem;
			}
		}
		throw new RuntimeException("Invalid Shape requested " + winsFrom);
	}

}

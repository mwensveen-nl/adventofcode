package nl.mwensveen.adventofcode.year_2022.day_02;

public enum Result {
	LOSE("X", 0), DRAW("Y", 3), WIN("Z", 6);

	private String letter;
	private int score;

	Result(String letter, int score) {
		this.letter = letter;
		this.score = score;
	}

	public static Result find(String letter) {
		for (Result elem : Result.values()) {
			if (elem.letter.equals(letter)) {
				return elem;
			}
		}
		throw new RuntimeException("Invalid Result requested " + letter);
	}

	public int getScore() {
		return score;
	}

}

package nl.mwensveen.adventofcode.year_2021.day_21;

public class Player {

	private long score = 0;
	private int position;

	public Player(int position) {
		this.position = position;
	}

	public Player(Player orig) {
		this(orig.getPosition());
		this.score = orig.getScore();
	}

	public long move(int steps) {
		position = getPosition() + steps;
		position = getPosition() % 10;
		if (getPosition() == 0) {
			position = 10;
		}
		score = getScore() + getPosition();
		return getScore();
	}

	public long getScore() {
		return score;
	}

	public int getPosition() {
		return position;
	}

}

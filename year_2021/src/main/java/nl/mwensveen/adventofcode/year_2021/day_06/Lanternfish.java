package nl.mwensveen.adventofcode.year_2021.day_06;

public class Lanternfish {
	private int timer;
	private long numberOfFish;

	public Lanternfish(int timer) {
		this.timer = timer;
		numberOfFish = 1;
	}

	public boolean nextDay() {
		if (timer == 0) {
			timer = 6;
			return true;
		}

		timer--;
		return false;
	}

	public static Lanternfish createNewFishs(long newFishes) {
		Lanternfish lanternfish = new Lanternfish(8);
		lanternfish.numberOfFish = newFishes;
		return lanternfish;
	}

	public long getNumberOfFish() {
		return numberOfFish;
	}

}

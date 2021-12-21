package nl.mwensveen.adventofcode.year_2021.day_21;

public class Player {

    private long score = 0;
    private int position;
    private String name;

    public Player(int position) {
        this.position = position;
    }

    public Player(Player orig) {
        this(orig.position);
        this.score = orig.score;
        this.name = orig.name;
    }

    public long move(int steps) {
        return move(steps, 1);
    }

    public long move(int steps, int universes) {
        position = getPosition() + steps * universes;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

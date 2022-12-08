package nl.mwensveen.adventofcode.year_2022.day_08;

public class Tree {
    private int height;
    private boolean visible;

    public Tree(int height) {
        this.height = height;
        visible = true;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}

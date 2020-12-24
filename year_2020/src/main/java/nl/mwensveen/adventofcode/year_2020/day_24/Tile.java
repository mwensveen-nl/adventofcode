package nl.mwensveen.adventofcode.year_2020.day_24;

import com.google.common.base.MoreObjects;

public class Tile {

    private final int sn;
    private final int ew;
    private Color color = Color.WHITE;

    public Tile(int sn, int ew) {
        this.sn = sn;
        this.ew = ew;
    }

    public Tile(String code) {
        int ne = code.split("ne", -1).length - 1;
        int se = code.split("se", -1).length - 1;
        int sw = code.split("sw", -1).length - 1;
        int nw = code.split("nw", -1).length - 1;
        int e = code.split("e", -1).length - 1 - ne - se;
        int w = code.split("w", -1).length - 1 - nw - sw;

        sn = se + sw - ne - nw;
        ew = se + ne - sw - nw - 2 * w + 2 * e;
    }

    public int getSn() {
        return sn;
    }

    public int getEw() {
        return ew;
    }

    public Color getColor() {
        return color;
    }

    public void flip() {
        if (color == Color.WHITE) {
            color = Color.BLACK;
        } else {
            color = Color.WHITE;
        }
    }

    public Tile copy() {
        Tile copy = new Tile(sn, ew);
        copy.color = color;
        return copy;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("sn", sn).add("ew", ew).add("color", color).toString();
    }
}

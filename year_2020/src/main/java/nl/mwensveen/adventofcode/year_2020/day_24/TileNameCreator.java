package nl.mwensveen.adventofcode.year_2020.day_24;

public class TileNameCreator {

    public String createTileName(String code) {
        int ne = code.split("ne", -1).length - 1;
        int se = code.split("se", -1).length - 1;
        int sw = code.split("sw", -1).length - 1;
        int nw = code.split("nw", -1).length - 1;
        int e = code.split("e", -1).length - 1 - ne - se;
        int w = code.split("w", -1).length - 1 - nw - sw;

        int sn = se + sw - ne - nw;
        int ew = se + ne - sw - nw - 2 * w + 2 * e;
        return "sn=" + sn + ",ew=" + ew;
    }

}

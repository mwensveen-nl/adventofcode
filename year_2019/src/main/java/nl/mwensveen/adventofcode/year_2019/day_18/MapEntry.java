package nl.mwensveen.adventofcode.year_2019.day_18;

import com.google.common.base.MoreObjects;

public class MapEntry {
    private Element element;
    private final char symbol;

    public MapEntry(Element element, char symbol) {
        super();
        this.element = element;
        this.symbol = symbol;
    }

    public Element getElement() {
        return element;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("element", element).add("symbol", symbol).toString();
    }

}

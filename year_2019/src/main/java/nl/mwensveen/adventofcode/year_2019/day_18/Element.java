package nl.mwensveen.adventofcode.year_2019.day_18;

public enum Element {
    WALL('#'),
    ENTRANCE('@'),
    PASSAGE('.'),
    KEY(' '),
    DOOR(' ');

    private char symbol;

    private Element(char symbol) {
        this.symbol = symbol;
    }

    public static Element valueOf(char symbol) {
        if (symbol >= 'a' && symbol <= 'z') {
            return KEY;
        }
        if (symbol >= 'A' && symbol <= 'Z') {
            return DOOR;
        }
        for (Element elem : Element.values()) {
            if (elem.symbol == symbol) {
                return elem;
            }
        }
        throw new RuntimeException("Invalid Element requested " + symbol);
    }

}
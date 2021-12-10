package nl.mwensveen.adventofcode.year_2021.day_10;

public enum Symbol {
	RoundOpen(true, null, 1, '('),
	RoundClose(false, RoundOpen, 3, ')'),
	SquareOpen(true, null, 2, ('[')),
	SqueareClose(false, SquareOpen, 57, ']'),
	ChocolateOpen(true, null, 3, '{'),
	ChocolateClose(false, ChocolateOpen, 1197, '}'),
	PointOpen(true, null, 4, '<'),
	PointClose(false, PointOpen, 25137, '>');

	private final boolean open;
	private final Symbol openSymbol;
	private final int value;
	private final Character symbol;

	Symbol(boolean open, Symbol openSymbol, int value, Character symbol) {
		this.open = open;
		this.openSymbol = openSymbol;
		this.value = value;
		this.symbol = symbol;

	}

	public static Symbol find(Character symbol) {
		for (Symbol elem : Symbol.values()) {
			if (elem.symbol.equals(symbol)) {
				return elem;
			}
		}
		throw new RuntimeException("Invalid Symbol requested " + symbol);
	}

	public boolean isOpen() {
		return open;
	}

	public Symbol getOpenSymbol() {
		return openSymbol;
	}

	public int getValue() {
		return value;
	}

	public Character getSymbol() {
		return symbol;
	}
}

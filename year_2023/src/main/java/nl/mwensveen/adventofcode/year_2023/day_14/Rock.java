package nl.mwensveen.adventofcode.year_2023.day_14;

public enum Rock {
	ROUND("O"),
	CUBE("#");

	private final String symbol;

	Rock(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public static Rock find(String symbol) {
		for (Rock elem : Rock.values()) {
			if (elem.symbol.equals(symbol)) {
				return elem;
			}
		}
		throw new RuntimeException("Invalid Rock requested " + symbol);
	}

}

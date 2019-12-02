package nl.mwensveen.adventofcode.year_2019.day_02;

public enum Opcode {
	ADD(1),
	MULTIPLY(2),
	STOP(99);

	private int code;

	Opcode(int i) {
		this.code = i;
	}

	public static Opcode valueOf(int i) {
		for (Opcode op : Opcode.values()) {
			if (op.code == i) {
				return op;
			}
		}
		throw new RuntimeException("Unknown opcode " + i);
	}
}

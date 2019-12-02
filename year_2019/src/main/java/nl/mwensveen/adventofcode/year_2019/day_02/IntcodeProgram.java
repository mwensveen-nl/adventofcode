package nl.mwensveen.adventofcode.year_2019.day_02;

import java.util.List;

public class IntcodeProgram {

	public Integer process(List<Integer> list) {
		int i = 0;
		Opcode opcode = Opcode.valueOf(list.get(i));
		while (Opcode.STOP != opcode) {
			if (Opcode.ADD == opcode) {
				add(list, i);
			} else {
				multiply(list, i);
			}
			i += 4;
			opcode = Opcode.valueOf(list.get(i));
		}
		return list.get(0);
	}

	private void add(List<Integer> list, int index) {
		int num1 = list.get(index + 1);
		int num2 = list.get(index + 2);
		int pos = list.get(index + 3);
		list.set(pos, list.get(num1) + list.get(num2));
	}

	private void multiply(List<Integer> list, int index) {
		int num1 = list.get(index + 1);
		int num2 = list.get(index + 2);
		int pos = list.get(index + 3);
		list.set(pos, list.get(num1) * list.get(num2));
	}
}

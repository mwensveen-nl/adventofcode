package nl.mwensveen.adventofcode.year_2017.day_5;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;

public class TwistyTrampolines {
	private List<Integer> instructions;

	public TwistyTrampolines(String numbers) {
		List<String> list = Splitter.on("\n").splitToList(numbers);
		instructions = list.stream().map(Integer::valueOf).collect(Collectors.toList());
	}
	
	public int calculate() {
		int i = 0;
		int position = 0;
		boolean outside = false;
		while (!outside) {
			int jump = instructions.get(position);
			instructions.set(position, instructions.get(position)+1);
			i++;
			int newPosistion = position + jump;
			if (newPosistion >= instructions.size()) {
				outside = true;
			}
			position = newPosistion;
		}
		return i;
	}
}

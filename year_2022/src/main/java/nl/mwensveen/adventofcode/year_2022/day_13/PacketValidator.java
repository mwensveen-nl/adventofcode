package nl.mwensveen.adventofcode.year_2022.day_13;

import java.util.List;
import java.util.Optional;

public class PacketValidator {

	public CompareResult validate(PacketPairs packet) {
		CompareResult valid = validate(packet.getLeftList(), packet.getRightList());
		if (valid == CompareResult.SAME) {
			return CompareResult.OK;
		}
		return valid;
	}

	private CompareResult validate(List<Object> leftList, List<Object> rightList) {
		for (int i = 0; i < leftList.size(); i++) {
			Object left = leftList.get(i);
			if (rightList.size() <= i) {
				return CompareResult.WRONG; // Right side ran out of items, so inputs are not in the right order
			}
			Object right = rightList.get(i);
			if (left instanceof Integer && right instanceof Integer) {
				int compare = ((Integer) left).compareTo((Integer) right);
				if (compare < 0) {
					return CompareResult.OK; // Left side is smaller, so inputs are in the right order
				}
				if (compare > 0) {
					return CompareResult.WRONG; // Right side is smaller, so inputs are not in the right order
				}
			} else if (left instanceof List && right instanceof List) {
				CompareResult valide = validate((List<Object>) left, (List<Object>) right);
				if (valide == CompareResult.WRONG || valide == CompareResult.OK) {
					return valide;
				}
			} else if (left instanceof Optional || right instanceof Optional) {
				if (!(left instanceof Optional)) {
					return CompareResult.WRONG; // Right side ran out of items, so inputs are not in the right order
				}
				if (!(right instanceof Optional)) {
					return CompareResult.OK; // Left side ran out of items, so inputs are in the right order
				}
			} else {
				// Mixed types
				CompareResult valide;
				if (left instanceof List) {
					valide = validate((List<Object>) left, List.of(right));
				} else {
					valide = validate(List.of(left), (List<Object>) right);
				}
				if (valide == CompareResult.WRONG || valide == CompareResult.OK) {
					return valide;
				}
			}
		}

		return CompareResult.SAME;
	}

}

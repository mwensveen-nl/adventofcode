package nl.mwensveen.adventofcode.year_2022.day_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PacketPairs {
	private final String left;
	private final String right;
	private final int number;

	private Map<String, Object> replacer = new HashMap<>();
	private char replaceKey = 'a';
	private List<Object> leftList;
	private List<Object> rightList;

	public PacketPairs(int number, String left, String right) {
		this.number = number;
		this.left = left.substring(1, left.length() - 1);
		this.right = right.substring(1, right.length() - 1);
		leftList = split(this.left);
		rightList = split(this.right);
	}

	private List<Object> split(String packet) {
		ArrayList<Object> values = new ArrayList<>();
		int index = packet.lastIndexOf("[");
		while (index >= 0) {
			int index2 = packet.indexOf("]", index);
			String subPacket = packet.substring(index + 1, index2);
			if (subPacket.isBlank()) {
				replacer.put(String.valueOf(replaceKey), Optional.empty());
				packet = packet.replace("[" + subPacket + "]", String.valueOf(replaceKey));
			} else {
				List<Object> subList = split(subPacket);
				replacer.put(String.valueOf(replaceKey), subList);
				packet = packet.replace("[" + subPacket + "]", String.valueOf(replaceKey));
			}
			replaceKey++;
			index = packet.lastIndexOf("[");
		}
		String[] split = packet.split(",");
		Arrays.stream(split).forEach(s -> {
			if (s.matches("[0-9]+")) {
				values.add(Integer.parseInt(s));
			} else {
				Object e = replacer.get(s);
				values.add(e == null ? Optional.empty() : e);
			}
		});
		return values;
	}

	public String getLeft() {
		return left;
	}

	public String getRight() {
		return right;
	}

	public List<Object> getLeftList() {
		return leftList;
	}

	public List<Object> getRightList() {
		return rightList;
	}

	public int getNumber() {
		return number;
	}

}

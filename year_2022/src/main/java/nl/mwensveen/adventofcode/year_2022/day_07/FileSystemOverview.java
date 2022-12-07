package nl.mwensveen.adventofcode.year_2022.day_07;

public class FileSystemOverview {

	private final Directory root = new Directory("/", null);
	private Directory current = root;

	public void processCommand(String cmd) {
		if (cmd.equals("$ cd /")) {
			current = root;
		} else if (cmd.equals("$ cd ..")) {
			current = current.getParent();
		} else if (cmd.startsWith("$ cd")) {
			current = current.toChildDir(cmd.split(" ")[2]);
		} else if (cmd.equals("$ ls")) {
			// ignore
		} else if (cmd.startsWith("dir")) {
			current.addChildDirectory(cmd.substring(4));
		} else {
			// file
			String[] split = cmd.split(" ");
			current.addFile(split[1], Long.valueOf(split[0]));
		}
	}

	public Directory getRoot() {
		return root;
	}

}

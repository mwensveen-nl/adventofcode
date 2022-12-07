package nl.mwensveen.adventofcode.year_2022.day_07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.MoreObjects;

public class Directory {

	private final String name;
	private final Directory parent;
	private final List<Directory> children = new ArrayList<>();
	private final Map<String, Long> files = new HashMap<>();

	private Long dirSize = 0L;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("name", name).add("children", children).add("files", files).toString();
	}

	public Directory(String name, Directory parent) {
		this.name = name;
		if (parent != null) {
			this.parent = parent;
			this.parent.children.add(this);
		} else {
			this.parent = null;
		}
	}

	public Directory getParent() {
		return parent;
	}

	public List<Directory> getChildren() {
		return children;
	}

	public Map<String, Long> getFiles() {
		return files;
	}

	public Long getDirSize() {
		return dirSize;
	}

	public void addDirectory(String name) {
		new Directory(name, this);
	}

	public void addFile(String name, Long size) {
		files.put(name, size);
		dirSize += size;
		Directory temp = parent;
		while (temp != null) {
			temp.dirSize += size;
			temp = temp.parent;
		}
	}

	public Directory toChildDir(String findName) {
		return children.stream().peek(d -> System.out.println(d.name)).filter(d -> d.name.equals(findName)).findFirst().get();
	}

}

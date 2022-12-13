package nl.mwensveen.adventofcode.year_2022.day_12;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Heightmap {

	private int startRow;
	private int startCol;
	private int endRow;
	private int endCol;
	private int currentRow;
	private int currentCol;
	private Table<Integer, Integer, Coordinate> coordinates = HashBasedTable.create();

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startX) {
		this.startRow = startX;
	}

	public int getStartCol() {
		return startCol;
	}

	public void setStartCol(int startY) {
		this.startCol = startY;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentX) {
		this.currentRow = currentX;
	}

	public int getCurrentCol() {
		return currentCol;
	}

	public void setCurrentCol(int currentY) {
		this.currentCol = currentY;
	}

	public Table<Integer, Integer, Coordinate> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Table<Integer, Integer, Coordinate> coordinates) {
		this.coordinates = coordinates;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endX) {
		this.endRow = endX;
	}

	public int getEndCol() {
		return endCol;
	}

	public void setEndCol(int endY) {
		this.endCol = endY;
	}
}

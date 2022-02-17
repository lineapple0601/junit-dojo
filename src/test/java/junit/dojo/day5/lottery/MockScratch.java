package junit.dojo.day5.lottery;

import junit.dojo.day5.IScratch;

public class MockScratch implements IScratch {
	
	private int[][] sheet;
	
	public void setSheet(int[][] sheet) {
		this.sheet = sheet;
	}
	
	public int getValue(int row, int col) {
		return sheet[row][col];
	}
}

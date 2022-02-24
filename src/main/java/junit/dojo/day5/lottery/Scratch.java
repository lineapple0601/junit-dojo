package junit.dojo.day5.lottery;

import java.util.Random;

/**
 * スクラッチくじを実装したクラスです。
 * {@code LotteryFactory}以外では
 * インスタンスを作成できないようpackage privateクラスにしています。
 *
 * @see LotteryFactory
 * @author autotaker
 *
 */
public class Scratch implements IScratch {
	int[][] sheet;

	public Scratch(Random rng) {
		this(new int[3][3]);
		this.sheet = makeSheet(rng);
	}
	
	public Scratch(int[][] sheet) {
		this.sheet = sheet;
	}
	
	private int[][] makeSheet(Random rng) {
		int[][] randomSheet = new int[3][3];
		for (int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				randomSheet[row][col] = rng.nextInt(9) + 1;
			}
		}
		return randomSheet;
	}
	
	@Override
	public int getValue(int row, int col) {
		return sheet[row][col];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int[] rowItem : sheet) {
			for( int digit: rowItem) {
				sb.append(digit);
			}
			sb.append('\n');
		}
		return sb.toString();
	}

}

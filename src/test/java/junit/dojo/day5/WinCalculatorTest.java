package junit.dojo.day5;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import junit.dojo.day5.lottery.Scratch;

@MockitoSettings
class WinCalculatorTest {

	MockScratch scratch = new MockScratch();
	WinCalculator it = new WinCalculator();
	
//	@BeforeEach
//	void setUp() {
//		
//	}
	
	@Test
	void 一行ででワンビンゴした値をチェックする() {
		assertThat(it.check(scratch), is(10L));
	}
	
	// パターン１；sheetの生成するFactoryメソッドを作成し、継承して入れ替える
	private static class MockScratch extends Scratch {
		MockScratch() {
			super(null);
		}

		@Override
		protected int[][] makeSheet(Random rng) {
			int[][] sheet = {
					{1, 1, 1},
					{4, 5, 6},
					{7, 8, 9}
			};
			return sheet;
		}
	}
}

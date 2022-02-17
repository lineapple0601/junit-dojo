package junit.dojo.day5.lottery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import junit.dojo.day5.IScratch;
import junit.dojo.day5.WinCalculator;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@MockitoSettings(strictness = Strictness.LENIENT)
class WinCaculatorTest {

	WinCalculator it = new WinCalculator();
	LotteryFactory factory = new LotteryFactory();
	
	@Mock
	IScratch scratch;
	
	@BeforeEach
	void setUp() {
		// MockitoAnnotations.initMocks(this); // Deprecated, plz use class annotation with @MockitoSettings
	}
	
	@Nested
	class Scratchの値をチェックする {
		@Test
		void 一でワンビンゴになる場合() {
			int[][] scratchArr = {
					{1, 1, 1},
					{2, 3, 4},
					{5, 6, 7}
			};
			doMockingScratch(scratchArr);
			assertThat(it.check(scratch), is(10L));
		}
		
		@Test
		void 四でワンビングのになる場合() {
			int[][] scratchArr = {
					{1, 2, 3},
					{5, 6, 7},
					{4, 4, 4}
			};
			doMockingScratch(scratchArr);
			assertThat(it.check(scratch), is(40L));
		}
		
		void doMockingScratch(int[][] scratchArr) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					when(scratch.getValue(i, j)).thenReturn(scratchArr[i][j]);
				}
			}
		}
	}
}

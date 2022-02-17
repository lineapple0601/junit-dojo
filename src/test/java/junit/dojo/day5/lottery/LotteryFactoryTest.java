package junit.dojo.day5.lottery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryFactoryTest {

	private LotteryFactory lotteryFactory = new LotteryFactory();
	private List<Integer> list = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8).collect(Collectors.toList());
	
	@Test
	@DisplayName("getValue(0, 0) の返り値が1-9の範囲にあること")
	void testGetValue_Case1() {
		Random random = new MockRandom(list);
		lotteryFactory.setRandom(random);
		
		assertThat(lotteryFactory.draw().getValue(0, 0), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(9)));
	}
	
	@Test
	@DisplayName("getValue(2, 2) の返り値が1-9の範囲にあること")
	void testGetValue_Case2() {
		Random random = new MockRandom(list);
		lotteryFactory.setRandom(random);
		
		assertThat(lotteryFactory.draw().getValue(2, 2), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(9)));
	}
	
	@Test
	@DisplayName("インスタンスの初期化時に iterator.nextInt(9)を９回呼び出すこと")
	void testGetValue_Case3() {
		MockRandom random = new MockRandom(list);
		lotteryFactory.setRandom(random);
		lotteryFactory.draw();
		
		assertThat(random.getNextIntCnt(), is(9));
	}

}

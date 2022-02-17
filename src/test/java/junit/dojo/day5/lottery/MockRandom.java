package junit.dojo.day5.lottery;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class MockRandom extends Random {
	
	private Iterator<Integer> iterator;
	
	public int nextIntCnt = 0;
	
	// Iteratorはそのまま受け取ることは危険
	// Iterator / InputStream / OutputStreamなど、
	// Indexがどうなっているか分からないのでListで受け取ってpositionをにすること
	public MockRandom(List<Integer> list) {
		this.iterator = list.iterator();
	}
	
	public Iterator<Integer> getIterator() {
		return iterator;
	}
	
	@Override
	public int nextInt(int bound) {
		nextIntCnt++;
		
		if (bound != 9) {
			throw new IllegalArgumentException("bound param is not 9");
		}
		return iterator.next().intValue();
	}
	
	public int getNextIntCnt() {
		return nextIntCnt;
	}
	
}

package junit.dojo.day3;

import com.google.common.annotations.VisibleForTesting;

public class Fibo {

	@VisibleForTesting
	static void validate(int idx) {
		if (idx <= 0) {
			throw new IllegalArgumentException();
		}
	}
	
	public int fibonacciValByIdx(int idx) {
		validate(idx);

		int n1 = 1;
		int n2 = 1;
		int n3 = 1;
		
		for (int i = 1; i <= idx; i++) {
			if (i == 1 || i == 2) {
				n3 = 1;
			} else {
				n3 = n1 + n2;
				n1 = n2;
				n2 = n3;
			}
		}
		
		return n3;
	}
}

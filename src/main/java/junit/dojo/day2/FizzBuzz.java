package junit.dojo.day2;

public class FizzBuzz {
	public String convert(int val) {
		if (val <= 0) {
			throw new IllegalArgumentException();
		}
				
		boolean canDividedByThree = (val % 3 == 0);
		boolean canDividedByFive = (val % 5 == 0);
		
		if (canDividedByThree && canDividedByFive) {
			return "FizzBuzz";
		}
		
		if (canDividedByThree) {
			return "Fizz";
		}
		
		if (canDividedByFive) {
			return "Buzz";
		}
		
		return String.valueOf(val);
	}
}

package junit.dojo.day2;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

class FizzBuzzTest {

	FizzBuzz fizzBuzz = new FizzBuzz();
	
	@Test
	void 引数が0以下ならIllegalArgumentExceptionをスローする() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->  {
			fizzBuzz.convert(0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->  {
			fizzBuzz.convert(-1);
		});
	}
	
	@Test
	void 引数が3と5と15以外の時は引数をStringにして返す() {
		assertThat(fizzBuzz.convert(1), is("1"));
		assertThat(fizzBuzz.convert(29), is("29"));
	}
	
	@Test
	void 引数が3の倍数の時はFizzを返す() {
		assertThat(fizzBuzz.convert(3), is("Fizz"));
		assertThat(fizzBuzz.convert(6), is("Fizz"));
		assertThat(fizzBuzz.convert(333), is("Fizz"));
	}
	
	@Test
	void 引数が5の倍数の時はBuzzを返す() {
		assertThat(fizzBuzz.convert(5), is("Buzz"));
		assertThat(fizzBuzz.convert(10), is("Buzz"));
		assertThat(fizzBuzz.convert(500), is("Buzz"));
	}
	
	@Test
	void 引数が15の倍数の時はFizzBuzzを返す() {
		assertThat(fizzBuzz.convert(15), is("FizzBuzz"));
		assertThat(fizzBuzz.convert(30), is("FizzBuzz"));
		assertThat(fizzBuzz.convert(151515), is("FizzBuzz"));
	}
}

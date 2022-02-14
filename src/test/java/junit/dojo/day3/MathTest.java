package junit.dojo.day3;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

class MathTest {

	private Fibo fibo;
	
	@BeforeEach
	void setUp() {
		fibo = new Fibo();
	}
	
	@Test
	void 引数が0以下の場合はIllegalArgumentExceptionをスローする() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fibo.fibonacciValByIdx(0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fibo.fibonacciValByIdx(-100);
		});
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "./data.csv", numLinesToSkip = 1)
	void フィボナッチ数列の値を取得する(int arg, int expected) {
		assertThat(fibo.fibonacciValByIdx(arg), is(expected));
	}

}

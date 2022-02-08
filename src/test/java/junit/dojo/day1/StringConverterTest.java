package junit.dojo.day1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringConverterTest {

	StringConverter converter = new StringConverter();

	@BeforeEach
	void setUp() {
		converter = new StringConverter();
	}

	@Nested
	class 仕様１アルファベットと数字は置換しない {
		@Test
		void 引数がabcxyzの場合はabcxyzを返す() {
			assertThat(converter.sanitizeName("abcxyze"), is("abcxyze"));
//			assertEquals("abcxyze", converter.sanitizeName("abcxyze"));
		}
		@Test
		void 引数が0123456789の場合0123456789を返す() {
			assertThat(converter.sanitizeName("0123456789"), is("0123456789"));
//			assertEquals("0123456789", converter.sanitizeName("0123456789"));
		}
	}

	@Nested
	class 仕様２空白をまとめてハイフンにする {
		@Test
		void 空白はハイフンに返す() {
			assertThat(converter.sanitizeName(" "), is(" "));
//			assertEquals("-", converter.sanitizeName(" "));
		}
		@Test
		void 空白はまとめてハイフンに返す() {
			assertThat(converter.sanitizeName("      "), is("-"));
//			assertEquals("-", converter.sanitizeName("      "));
		}
		@Test
		void 改行はハイフンに返す() {
			assertThat(converter.sanitizeName("\n"), is("-"));
//			assertEquals("-", converter.sanitizeName("\n"));
		}
		@Test
		void インデントはハイフンに返す() {
			assertThat(converter.sanitizeName("\t"), is("-"));
//			assertEquals("-", converter.sanitizeName("\t"));
		}
		@Test
		void 連続する空白と改行とインデントはまとめてハイフンに返す() {
			assertThat(converter.sanitizeName("\t \n"), is("-"));
//			assertEquals("-", converter.sanitizeName("\t \n"));
		}
	}

	@Nested
	class 仕様３大文字を小文字に置換する {
		@Test
		void 大文字のみ小文字に変換する() {
			assertThat(converter.sanitizeName("1aBcXyZ9"), is("1abcxyz9"));
//			assertThat(converter.sanitizeName("1aBcXyZ9"), is(equalToIgnoringCase("1ABCXYZ9")));
//			assertEquals("1abcxyz9", converter.sanitizeName("1aBcXyZ9"));
		}
	}

	@Nested
	class 仕様４アルファベットと数字以外をアンダースコアに変換する {
		@Test
		void 記号をアンダースコアに変換する() {
			assertEquals("___", converter.sanitizeName("$-$"));
		}
		@Test
		void 全角文字をアンダースコアに変換する() {
			assertEquals("_______", converter.sanitizeName("アイ上お下한글"));
		}
	}
	
	@Nested
	class 例外処理 {
		@Test
		void 引数がNullの場合はNullPointerExceptionをスローする() {
			String EXPECTED_ERROR_MSG = "引数にNullが入ってます。";
			try {
				converter.sanitizeName(null);
				// With Sprout Class
				StringConverter.Validator validator = new StringConverter.Validator();
				validator.validate(null);
				Assertions.fail();
			} catch (NullPointerException e) {
				assertThat(e.getMessage(), is(EXPECTED_ERROR_MSG));
			}
		}
		@Test
		void 引数が空文字の場合はIllegalArgumentExceptionをスローする() {
			String EXPECTED_ERROR_MSG = "引数に空文字が入ってます。";
			try {
				converter.sanitizeName("");
				// With Sprout Class
				StringConverter.Validator validator = new StringConverter.Validator();
				validator.validate("");
				Assertions.fail();
			} catch (IllegalArgumentException e) {
				assertThat(e.getMessage(), is(EXPECTED_ERROR_MSG));
			}
		}
	}

	@Nested
	class 総合テスト {
		@Test
		void 総合テスト１() {
			assertThat(converter.sanitizeName("あい上オabc    xyz \n\t123$456%#789"), is("____abc-xyz-123_456__789"));
		}
	}
}
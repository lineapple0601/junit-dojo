package junit.dojo.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
			assertEquals("abcxyz", converter.sanitizeName("abcxyz"));
		}
		@Test
		void 引数が0123456789の場合0123456789を返す() {
			assertEquals("0123456789", converter.sanitizeName("0123456789"));
		}
	}

	@Nested
	class 仕様２空白をまとめてハイフンにする {
		@Test
		void 空白はハイフンに返す() {
			assertEquals("-", converter.sanitizeName(" "));
		}
		@Test
		void 空白はまとめてハイフンに返す() {
			assertEquals("-", converter.sanitizeName("      "));
		}
		@Test
		void 改行はハイフンに返す() {
			assertEquals("-", converter.sanitizeName("\n"));
		}
		@Test
		void インデントはハイフンに返す() {
			assertEquals("-", converter.sanitizeName("\t"));
		}
		@Test
		void 連続する空白と改行とインデントはまとめてハイフンに返す() {
			assertEquals("-", converter.sanitizeName("\t \n"));
		}
	}

	@Nested
	class 仕様３大文字を小文字に置換する {
		@Test
		void 大文字のみ小文字に変換する() {
			assertEquals("1abcxyz9", converter.sanitizeName("1aBcXyZ9"));
		}
	}

	@Nested
	class 仕様４アルファベットと数字以外をアンダースコアに変換する {
		@Test
		void 記号をアンダースコアに変換する() {
			assertEquals("_", converter.sanitizeName("$"));
		}
		@Test
		void 全角文字をアンダースコアに変換する() {
			assertEquals("_______", converter.sanitizeName("アイ上お下한글"));
		}
	}

	@Nested
	class 総合テスト {
		@Test
		void 総合テスト１() {
			assertEquals("____abc-xyz-123_456__789", converter.sanitizeName("あい上オabc    xyz \n\t123$456%#789"));
		}
	}
}
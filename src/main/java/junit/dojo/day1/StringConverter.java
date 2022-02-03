package junit.dojo.day1;

public class StringConverter {
	/**
	 * 引数に含まれる[a-z0-9]以外の文字を置換してください
	 * 仕様1: [a-z0-9]の文字は置換しないでください
	 * 仕様2: 空白文字はまとめてハイフン（-）に置換してください
	 *       (例: @{code: "hoge  \nfuga"}は @{code: "hoge-fuga"})
	 * 仕様3: 大文字は小文字にしてください
	 * 仕様4: それ以外の文字は１文字ずつアンダースコア(_)に置換してください
	 * @param name
	 * @return @{code: "[a-z0-9_-]*"}のみを含む文字列
	 */
	public String sanitizeName(String name) {
		char[] charArr = name.toCharArray();
		StringBuilder result = new StringBuilder();

		for (char chr : charArr) {
			result.append(convertChr(chr));
		}
		
		return result.toString();
	}
	
	private boolean checkWhitespaceConverted = false;
	
	private String convertChr(char chr) {
		// 空白文字の場合
		if (Character.isWhitespace(chr)) {
			if (!checkWhitespaceConverted) {
				checkWhitespaceConverted = true;
				return "-";
			}
			return "";
		}
		// 空白文字以外の場合
		checkWhitespaceConverted = false;
		if (Character.isUpperCase(chr)) {
			return String.valueOf(Character.toLowerCase(chr));
		}
		if (Character.isLowerCase(chr) || Character.isDigit(chr)) {
			return String.valueOf(chr);
		}
		return "_";
	}
}

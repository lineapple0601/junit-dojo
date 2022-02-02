package day1;

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
		char[] charArray = name.toCharArray();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < charArray.length; i++) {
			if (i > 0 && isEachCharWhiteSpaceOnPrevAndCurrIdx(charArray, i)) {
				continue;
			} else if (Character.isWhitespace(charArray[i])) {
				result.append("-");
			} else if (Character.isLetterOrDigit(charArray[i])) {
				result.append(Character.toLowerCase(charArray[i]));
			} else {
				result.append("_");
			}
		}
		return result.toString();
	}

	private boolean isEachCharWhiteSpaceOnPrevAndCurrIdx(char[] charArray, int i) {
		return (Character.isWhitespace(charArray[i]) && Character.isWhitespace(charArray[i - 1]));
	}

}

package May2021Leetcode;

public class _0408ValidAbbreviation {

	public static void main(String[] args) {
		System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
		System.out.println(validWordAbbreviation("apple", "a2e"));
	}

	public static boolean validWordAbbreviation(String word, String abbr) {
		int wordIndex = 0, abbrIndex = 0;
		while (wordIndex < word.length() && abbrIndex < abbr.length()) {
			if (word.charAt(wordIndex) == abbr.charAt(abbrIndex)) {
				wordIndex++;
				abbrIndex++;
				continue;
			}

			if (abbr.charAt(abbrIndex) <= '0' || abbr.charAt(abbrIndex) > '9')
				return false;

			String str = "";
			while (abbrIndex < abbr.length() && abbr.charAt(abbrIndex) >= '0' && abbr.charAt(abbrIndex) <= '9') {
				str += abbr.charAt(abbrIndex);
				abbrIndex++;
			}

			int num = Integer.parseInt(str);
			wordIndex += num;
		}
		return wordIndex == word.length() && abbrIndex == abbr.length();
	}

}

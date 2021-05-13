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

			char c = abbr.charAt(abbrIndex);

			if (c == '0' || !Character.isDigit(c))
				return false;

			int count = 0;
			String str = "";
			while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
				str += abbr.charAt(abbrIndex);
				abbrIndex++;
			}
			
			count = Integer.parseInt(str);
			
			
			if(wordIndex+count>word.length())
				return false;
			wordIndex+=count;
		}
		return wordIndex == word.length() && abbrIndex == abbr.length();
	}

}

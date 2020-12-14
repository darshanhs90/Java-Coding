package Nov2020_GoogPrep;

public class _018ExpressiveWords {

	public static void main(String[] args) {
		System.out.println(expressiveWords("heeellooo", new String[] { "hello", "hi", "helo" }));
		System.out.println(expressiveWords("abcd", new String[] { "abc" }));
		System.out.println(expressiveWords("dddiiiinnssssssoooo", new String[] { "dinnssoo", "ddinso", "ddiinnso",
				"ddiinnssoo", "ddiinso", "dinsoo", "ddiinsso", "dinssoo", "dinso" }));
	}
x
	public static int expressiveWords(String S, String[] words) {
		int wordsCount = 0;
		for (int i = 0; i < words.length; i++) {
			int sIndex = 0;
			int wIndex = 0;
			String currWord = words[i];
			boolean isValid = true;
			while (sIndex < S.length() && wIndex < currWord.length()) {
				int currCharCount = 0;
				char sChar = S.charAt(sIndex);
				char wChar = currWord.charAt(wIndex);
				if (sChar == wChar) {
					if (wIndex + 1 < currWord.length() && currWord.charAt(wIndex + 1) == wChar) {
						sIndex++;
						wIndex++;
						continue;
					} else {
						while (sIndex < S.length() && wChar == sChar) {
							sIndex++;
							currCharCount++;
							if (sIndex < S.length())
								sChar = S.charAt(sIndex);
						}
						if (currCharCount == 2) {
							isValid = false;
							break;
						}
						wIndex++;
					}
				} else {
					isValid = false;
					break;
				}
			}
			if (isValid)
				wordsCount++;
		}
		return wordsCount;
	}
}

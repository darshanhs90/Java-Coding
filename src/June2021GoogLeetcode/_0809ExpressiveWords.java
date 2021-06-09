package June2021GoogLeetcode;

public class _0809ExpressiveWords {
	public static void main(String[] args) {
		System.out.println(expressiveWords("heeellooo", new String[] { "hello", "hi", "helo" }));
	}

	public static int expressiveWords(String s, String[] words) {
		int count = 0;
		for (String word : words) {
			if (compare(s, word)) {
				count++;
			}
		}
		return count;
	}

	public static boolean compare(String s, String word) {
		int sIndex = 0, wordIndex = 0;
		while (sIndex < s.length() && wordIndex < word.length()) {
			if (s.charAt(sIndex) == word.charAt(wordIndex)) {
				int sLen = getRepeatedLen(s, sIndex);
				int wordLen = getRepeatedLen(word, wordIndex);

				if (sLen == wordLen || sLen >= wordLen + 2) {
					sIndex += sLen;
					wordIndex += wordLen;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return sIndex == s.length() && wordIndex == word.length();
	}

	public static int getRepeatedLen(String s, int index) {
		int newIndex = index;
		while (newIndex < s.length() && s.charAt(newIndex) == s.charAt(index)) {
			newIndex++;
		}
		return newIndex - index;
	}
}

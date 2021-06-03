package May2021GoogLeetcode;

public class _0809ExpressiveWords {
	public static void main(String[] args) {
		System.out.println(expressiveWords("heeellooo", new String[] { "hello", "hi", "helo" }));
	}

	public static int expressiveWords(String s, String[] words) {
		int count = 0;
		for (String str : words) {
			if (isStretchy(str, s)) {
				count++;
			}
		}
		return count;
	}

	public static boolean isStretchy(String s, String baseWord) {
		int index1 = s.length() - 1;
		int index2 = baseWord.length() - 1;
		while (index1 >= 0 || index2 >= 0) {
			if (index1 >= 0 && index2 >= 0) {
				if (s.charAt(index1) == baseWord.charAt(index2)) {
					index1--;
					index2--;
				} else {
					if (index1 + 1 >= s.length())
						return false;
					char prevChar = s.charAt(index1 + 1);

					int count = 1;
					while (index2 >= 0 && baseWord.charAt(index2) == prevChar) {
						count++;
						index2--;
					}

					if (count < 3)
						return false;
				}
			} else if (index2 >= 0) {
				char prevChar = s.charAt(index1 + 1);
				int count = 1;
				while (index2 >= 0 && baseWord.charAt(index2) == prevChar) {
					count++;
					index2--;
				}
				if (count < 3)
					return false;

			} else {
				return false;
			}
		}
		return index1 < 0 && index2 < 0;
	}
}

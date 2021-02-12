package Jan2021Leetcode;

public class _0459RepeatedSubstringPattern {

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
	}

	public static boolean repeatedSubstringPattern(String s) {
		if(s == null || s.length() == 0)
			return true;
		int maxLen = s.length() / 2;
		for (int i = 1; i <= maxLen; i++) {
			String str = s.substring(0, i);
			if (checkFunc(i, i, str, s))
				return true;
		}
		return false;
	}

	public static boolean checkFunc(int length, int startIndex, String checkString, String s) {
		while (startIndex < s.length()) {
			if (startIndex + length > s.length())
				return false;
			String subStr = s.substring(startIndex, startIndex + length);
			if (!checkString.endsWith(subStr))
				return false;
			startIndex += length;
		}
		return startIndex == s.length();
	}
}

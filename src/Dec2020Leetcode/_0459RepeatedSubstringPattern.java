package Dec2020Leetcode;

public class _0459RepeatedSubstringPattern {

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
	}

	public static boolean repeatedSubstringPattern(String s) {

		for (int i = 1; i <= s.length() / 2; i++) {
			String str = s.substring(0, i);
			int j = i;
			for (j = i; j + i <= s.length(); j += i) {
				String strNew = s.substring(j, j + i);
				if (!str.equals(strNew))
					break;
			}
			if (j == s.length())
				return true;
		}
		return false;
	}
}

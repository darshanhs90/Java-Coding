package Nov2020Leetcode;

public class _0459RepeatedSubstringPattern {

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
	}

	public static boolean repeatedSubstringPattern(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb = sb.append(s.charAt(i));
			if (sb.length() > s.length() / 2) {
				return false;
			}
			if (s.length() % sb.length() == 0) {
				boolean isSubsstring = false;
				for (int j = i + 1; j < s.length(); j += sb.length()) {
					if (s.substring(j, j + sb.length()).contentEquals(sb)) {
						isSubsstring = true;
					} else {
						isSubsstring = false;
						break;
					}
				}
				if (isSubsstring)
					return true;
			}
		}

		return false;
	}
}

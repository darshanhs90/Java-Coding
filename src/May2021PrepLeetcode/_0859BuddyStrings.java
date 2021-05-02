package May2021PrepLeetcode;

public class _0859BuddyStrings {
	public static void main(String[] args) {
		System.out.println(buddyStrings("ab", "ba"));
		System.out.println(buddyStrings("ab", "ab"));
		System.out.println(buddyStrings("aa", "aa"));
		System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
		System.out.println(buddyStrings("", "aa"));
		System.out.println(buddyStrings("abcaa", "abcbb"));
	}

	public static boolean buddyStrings(String A, String B) {
		if (A.length() != B.length())
			return false;
		if (A.equals(B)) {
			int[] count = new int[26];
			for (int i = 0; i < A.length(); i++) {
				char c = A.charAt(i);
				count[c - 'a']++;

				if (count[c - 'a'] > 1)
					return true;
			}
			return false;
		} else {
			int first = -1, second = -1;

			for (int i = 0; i < A.length(); i++) {
				char c1 = A.charAt(i);
				char c2 = B.charAt(i);

				if (c1 != c2) {
					if (first == -1) {
						first = i;
					} else if (second == -1) {
						second = i;
					} else {
						return false;
					}
				}
			}

			return first != -1 && second != -1 && A.charAt(first) == B.charAt(second)
					&& A.charAt(second) == B.charAt(first);
		}
	}
}

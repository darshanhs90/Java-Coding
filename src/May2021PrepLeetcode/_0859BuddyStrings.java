package May2021PrepLeetcode;

import java.util.HashMap;

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
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < A.length(); i++) {
				char c = A.charAt(i);
				map.compute(c, (k, v) -> v == null ? 1 : v + 1);
				if (map.get(c) > 1)
					return true;
			}
		} else {
			int first = -1;
			int second = -1;
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
		return false;
	}
}

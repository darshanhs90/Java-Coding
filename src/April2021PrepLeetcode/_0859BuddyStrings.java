package April2021PrepLeetcode;

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
				count[A.charAt(i) - 'a']++;

				if (count[A.charAt(i) - 'a'] > 1)
					return true;
			}
			return false;
		} else {
			int index1 = -1, index2 = -1;
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) != B.charAt(i)) {
					if (index1 == -1) {
						index1 = i;
					} else if (index2 == -1) {
						index2 = i;
					} else {
						return false;
					}
				}
			}
			return index1 != -1 && index2 != -1 && A.charAt(index1) == B.charAt(index2)
					&& A.charAt(index2) == B.charAt(index1);

		}
	}
}

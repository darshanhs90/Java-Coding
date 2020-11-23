package Nov2020Leetcode;

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
		if (A.length() != B.length() || A.length() < 2)
			return false;

		int diff = 0;
		int[] charArr = new int[26];
		Integer firstIndex = null, secondIndex = null;
		boolean canSwitch = false;
		for (int i = 0; i < A.length(); i++) {
			charArr[A.charAt(i) - 'a']++;
			if (charArr[A.charAt(i) - 'a'] > 1) {
				canSwitch = true;
			}
			if (A.charAt(i) != B.charAt(i)) {
				diff++;
				if (firstIndex == null) {
					firstIndex = i;
				} else {
					secondIndex = i;
				}
			}
			if (diff > 2)
				return false;
		}

		return diff == 0 && canSwitch || diff == 2 && A.charAt(firstIndex) == B.charAt(secondIndex)
				&& A.charAt(secondIndex) == B.charAt(firstIndex);
	}
}

package Jan2021Leetcode;

public class _0647PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
	}

	public static int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += getPalindromes(s, i, i);

			count += getPalindromes(s, i, i + 1);
		}
		return count;
	}

	public static int getPalindromes(String s, int left, int right) {
		int count = 0;

		while (left >= 0 && right <= s.length() - 1) {
			if (s.charAt(left) != s.charAt(right))
				break;
			left--;
			right++;
			count++;
		}

		return count;
	}
}

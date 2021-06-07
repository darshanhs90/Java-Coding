package June2021GoogLeetcode;

public class _0647PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
	}

	public static int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += palindrome(i, i, s);
			if (i + 1 < s.length()) {
				count += palindrome(i, i + 1, s);
			}
		}
		return count;
	}

	public static int palindrome(int left, int right, String s) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
		return count;
	}
}

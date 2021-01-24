package Dec2020Leetcode;

public class _1328BreakAPalindrome {
	public static void main(String[] args) {
		System.out.println(breakPalindrome("abccba"));
		System.out.println(breakPalindrome("a"));
	}

	public static String breakPalindrome(String palindrome) {
		char[] cArr = palindrome.toCharArray();
		for (int i = 0; i < cArr.length / 2; i++) {
			if (cArr[i] != 'a') {
				cArr[i] = 'a';
				return new String(cArr);
			}
		}
		int length = cArr.length;
		cArr[length - 1] = 'b';

		return length < 2 ? "" : new String(cArr);
	}

}

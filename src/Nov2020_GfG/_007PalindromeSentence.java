package Nov2020_GfG;

public class _007PalindromeSentence {

	public static void main(String[] args) {
		System.out.println(sentencePalindrome("race car"));
		System.out.println(sentencePalindrome("hello world"));
	}

	static boolean sentencePalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);
			if (Character.isAlphabetic(leftChar) && Character.isAlphabetic(rightChar)) {
				if (leftChar != rightChar)
					return false;
				left++;
				right--;
			} else if (Character.isAlphabetic(leftChar)) {
				right--;
			} else {
				left++;
			}
		}
		return true;
	}
}

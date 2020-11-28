package Nov2020_FBPrep;

public class _012ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("0p"));
	}

	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;
		char[] charArr = s.toCharArray();
		int leftIndex = 0, rightIndex = s.length() - 1;
		while (leftIndex < rightIndex) {
			char leftChar = Character.toLowerCase(charArr[leftIndex]);
			char rightChar = Character.toLowerCase(charArr[rightIndex]);
			boolean isValidleftChar = Character.isAlphabetic(leftChar) || Character.isDigit(leftChar);
			boolean isValidRightChar = Character.isAlphabetic(rightChar) || Character.isDigit(rightChar);

			if (isValidleftChar && isValidRightChar) {
				if (leftChar != rightChar)
					return false;
				leftIndex++;
				rightIndex--;
			} else if (isValidleftChar) {
				rightIndex--;
			} else if (isValidRightChar) {
				leftIndex++;
			} else {
				leftIndex++;
				rightIndex--;
			}
		}
		return true;
	}
}

package Oct2023Leetcode;

public class _0917ReverseOnlyLetters {
	public static void main(String[] args) {
		System.out.println(reverseOnlyLetters("ab-cd"));
		System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
		System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}

	public static String reverseOnlyLetters(String s) {
		char[] cArr = s.toCharArray();
		int left = 0, right = s.length() - 1;
		while (left < right) {
			boolean isLeftChar = Character.isLetter(cArr[left]);
			boolean isRightChar = Character.isLetter(cArr[right]);
			if (isLeftChar && isRightChar) {
				char temp = cArr[left];
				cArr[left] = cArr[right];
				cArr[right] = temp;
				left++;
				right--;
			} else if (isLeftChar) {
				right--;
			} else {
				left++;
			}
		}
		return new String(cArr);
	}
}

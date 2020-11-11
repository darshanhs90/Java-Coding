package Leetcode2020Nov;

public class _0917ReverseOnlyLetters {
	public static void main(String[] args) {
		System.out.println(reverseOnlyLetters("ab-cd"));
		System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
		System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}

	public static String reverseOnlyLetters(String S) {
		char[] cArr = S.toCharArray();
		int leftIndex = 0;
		int rightIndex = S.length() - 1;
		while (leftIndex < rightIndex) {
			boolean isLeftChar = Character.isLetter(cArr[leftIndex]);
			boolean isRightChar = Character.isLetter(cArr[rightIndex]);
			if (isLeftChar && isRightChar) {
				char temp = cArr[leftIndex];
				cArr[leftIndex] = cArr[rightIndex];
				cArr[rightIndex] = temp;
				leftIndex++;
				rightIndex--;
			} else if (isLeftChar) {
				rightIndex--;
			} else {
				leftIndex++;
			}
		}
		return new String(cArr);
	}
}

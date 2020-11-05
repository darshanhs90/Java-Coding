package Leetcode2020Nov;

public class _0345ReverseVowelsOfAString {

	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
	}

	public static String reverseVowels(String s) {
		int leftIndex = 0;
		int rightIndex = s.length() - 1;
		char[] arr = s.toCharArray();
		while (leftIndex < rightIndex) {
			char leftChar = arr[leftIndex];
			char rightChar = arr[rightIndex];
			boolean isLeftVowel = isVowel(leftChar);
			boolean isRightVowel = isVowel(rightChar);
			if (isLeftVowel && isRightVowel) {
				arr[rightIndex] = leftChar;
				arr[leftIndex] = rightChar;
				leftIndex++;
				rightIndex--;
			} else if (isLeftVowel) {
				rightIndex--;
			} else {
				leftIndex++;
			}
		}
		return new String(arr);
	}

	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U';
	}
}

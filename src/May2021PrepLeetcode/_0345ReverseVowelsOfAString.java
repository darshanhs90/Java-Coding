package May2021PrepLeetcode;

public class _0345ReverseVowelsOfAString {

	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
	}

	public static String reverseVowels(String s) {
		char[] cArr = s.toCharArray();
		int left = 0, right = s.length() - 1;
		while (left < right) {
			char leftChar = cArr[left];
			char rightChar = cArr[right];

			if (isVowel(leftChar) && isVowel(rightChar)) {
				cArr[left] = rightChar;
				cArr[right] = leftChar;
				left++;
				right--;
			} else if (isVowel(leftChar)) {
				right--;
			} else if (isVowel(rightChar)) {
				left++;
			} else {
				left++;
				right--;
			}
		}
		return new String(cArr);
	}

	public static boolean isVowel(Character c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U';
	}
}

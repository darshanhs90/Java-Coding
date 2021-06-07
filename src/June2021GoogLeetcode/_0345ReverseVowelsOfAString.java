package June2021GoogLeetcode;

public class _0345ReverseVowelsOfAString {

	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
	}

	public static String reverseVowels(String s) {
		int left = 0, right = s.length() - 1;
		char cArr[] = s.toCharArray();
		while (left < right) {
			if (isVowel(cArr[left]) && isVowel(cArr[right])) {
				char temp = cArr[left];
				cArr[left] = cArr[right];
				cArr[right] = temp;
				left++;
				right--;
			} else if (isVowel(cArr[left])) {
				right--;
			} else if (isVowel(cArr[right])) {
				left++;
			} else {
				left++;
				right--;
			}
		}
		return new String(cArr);
	}

	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U';
	}
}

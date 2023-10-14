package Oct2023Leetcode;

public class _2000ReversePrefixOfWord {
	public static void main(String[] args) {
		System.out.println(reversePrefix("abcdefd", 'd'));
		System.out.println(reversePrefix("xyxzxe", 'z'));
		System.out.println(reversePrefix("abcd", 'z'));
	}

	public static String reversePrefix(String word, char ch) {
		char[] cArr = word.toCharArray();
		int left = 0, right = 0;
		for (right = 0; right < cArr.length; right++) {
			if (cArr[right] == ch) {
				break;
			}
		}
		while (left < right && right != cArr.length) {
			char temp = cArr[left];
			cArr[left] = cArr[right];
			cArr[right] = temp;
			left++;
			right--;
		}
		return new String(cArr);
	}
}

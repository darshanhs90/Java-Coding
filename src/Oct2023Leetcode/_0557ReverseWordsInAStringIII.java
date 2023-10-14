package Oct2023Leetcode;

public class _0557ReverseWordsInAStringIII {
	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

	public static String reverseWords(String s) {
		String[] words = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			sb.append(reverseWord(words[i]));
			if (i != words.length - 1)
				sb.append(" ");
		}
		return sb.toString();
	}

	public static String reverseWord(String s) {
		char[] cArr = s.toCharArray();
		int left = 0, right = cArr.length - 1;
		while (left < right) {
			char temp = cArr[left];
			cArr[left] = cArr[right];
			cArr[right] = temp;
			left++;
			right--;
		}
		return new String(cArr);
	}

}

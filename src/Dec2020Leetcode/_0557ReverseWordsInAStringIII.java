package Dec2020Leetcode;

public class _0557ReverseWordsInAStringIII {
	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

	public static String reverseWords(String s) {
		String[] strSplit = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strSplit.length; i++) {
			String word = strSplit[i];
			for (int j = word.length() - 1; j >= 0; j--) {
				sb.append(word.charAt(j));
			}

			if (i != strSplit.length - 1)
				sb.append(" ");
		}
		return sb.toString();
	}

}

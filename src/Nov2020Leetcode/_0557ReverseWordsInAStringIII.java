package Nov2020Leetcode;

public class _0557ReverseWordsInAStringIII {
	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

	public static String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		String[] sArray = s.split(" ");
		for (int i = 0; i < sArray.length; i++) {
			StringBuilder tempString = new StringBuilder(sArray[i]);
			sb = sb.append(tempString.reverse());
			if (i != sArray.length - 1)
				sb.append(" ");
		}
		return sb.toString();
	}
}

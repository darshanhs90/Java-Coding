package Leetcode2020Nov;

public class _1047RemoveAllAdjacentDuplicatesInString {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbaca"));
		System.out.println(removeDuplicates("aaaaaaaaa"));
	}

	public static String removeDuplicates(String S) {
		if (S == null || S.length() == 0)
			return S;
		StringBuilder sb = new StringBuilder(S);
		int index = 0;
		while (sb.length() > 0 && index < sb.length()) {
			if (index - 1 > -1 && sb.charAt(index - 1) == sb.charAt(index)) {
				sb = sb.deleteCharAt(index);
				sb = sb.deleteCharAt(index - 1);
				index--;
			} else {
				index++;
			}
		}
		return sb.toString();
	}
}

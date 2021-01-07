package Dec2020Leetcode;

public class _0541ReverseStringII {

	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg", 2));
	}

	public static String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {

			int kIndex = Math.min(i + k - 1, s.length() - 1);
			for (int j = kIndex; j >= i; j--) {
				sb.append(s.charAt(j));
			}

			i = kIndex + 1;

			if (i < s.length()) {
				kIndex = Math.min(i + k - 1, s.length() - 1);

				for (int j = i; j <= kIndex; j++) {
					sb.append(s.charAt(j));
				}
				i = kIndex;
			}
		}
		return sb.toString();
	}
}

package May2021Leetcode;

public class _0921MinimumAddToMakeParenthesesValid {
	public static void main(String[] args) {
		System.out.println(minAddToMakeValid("())"));
		System.out.println(minAddToMakeValid("((("));
		System.out.println(minAddToMakeValid("()"));
		System.out.println(minAddToMakeValid("()))(("));
	}

	public static int minAddToMakeValid(String s) {
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				sb.append(c);
				count++;
			} else if (c == ')') {
				if (count > 0) {
					sb.append(c);
					count--;
				} else {
					sb.append("()");
				}
			} else {
				sb.append(c);
			}
		}

		s = sb.toString();
		sb = new StringBuilder();
		count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == ')') {
				sb.append(c);
				count++;
			} else if (c == '(') {
				if (count > 0) {
					sb.append(c);
					count--;
				} else {
					sb.append(")(");
				}
			} else {
				sb.append(c);
			}
		}
		return sb.length() - length;
	}
}

package May2021PrepLeetcode;

public class _0921MinimumAddToMakeParenthesesValid {
	public static void main(String[] args) {
		System.out.println(minAddToMakeValid("())"));
		System.out.println(minAddToMakeValid("((("));
		System.out.println(minAddToMakeValid("()"));
		System.out.println(minAddToMakeValid("()))(("));
	}

	public static int minAddToMakeValid(String s) {
		int originalLength = s.length();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
				sb.append(c);
			} else {
				if (count > 0) {
					sb.append(c);
					count--;
				} else {
					sb.append("(");
					sb.append(c);
				}
			}
		}

		s = sb.toString();
		count = 0;
		sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == ')') {
				count++;
				sb.append(c);
			} else {
				if (count > 0) {
					sb.append(c);
					count--;
				} else {
					sb.append(")");
					sb.append(c);
				}
			}
		}
		return sb.length() - originalLength;
	}
}

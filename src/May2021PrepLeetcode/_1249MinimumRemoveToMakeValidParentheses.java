package May2021PrepLeetcode;

public class _1249MinimumRemoveToMakeValidParentheses {
	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(minRemoveToMakeValid("a)b(c)d"));
		System.out.println(minRemoveToMakeValid("))(("));
		System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
	}

	public static String minRemoveToMakeValid(String s) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				sb.append(c);
				count++;
			} else if (c == ')') {
				if (count > 0) {
					sb.append(c);
					count--;
				}
			} else {
				sb.append(c);
			}
		}

		count = 0;
		s = sb.toString();
		sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == ')') {
				sb.append(c);
				count++;
			} else if (c == '(') {
				if (count > 0) {
					sb.append(c);
					count--;
				}
			} else {
				sb.append(c);
			}
		}

		return sb.reverse().toString();
	}

}

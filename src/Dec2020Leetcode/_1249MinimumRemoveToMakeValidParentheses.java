package Dec2020Leetcode;

public class _1249MinimumRemoveToMakeValidParentheses {
	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(minRemoveToMakeValid("a)b(c)d"));
		System.out.println(minRemoveToMakeValid("))(("));
		System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
	}

	public static String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
			}
			if (count < 0) {
				count = 0;
			} else {
				sb.append(c);
			}
		}

		String str = sb.reverse().toString();
		sb = new StringBuilder();
		count = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ')') {
				count++;
			} else if (c == '(') {
				count--;
			}
			if (count < 0) {
				count = 0;
			} else {
				sb.append(c);
			}
		}
		return sb.reverse().toString();
	}

}

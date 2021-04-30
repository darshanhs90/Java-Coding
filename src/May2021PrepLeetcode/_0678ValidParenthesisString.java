package May2021PrepLeetcode;

public class _0678ValidParenthesisString {

	public static void main(String[] args) {
		System.out.println(checkValidString("()"));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*))"));
	}

	public static boolean checkValidString(String s) {
		if (s == null || s.length() == 0)
			return true;
		return dfs(0, 0, 0, s);
	}

	public static boolean dfs(int index, int left, int right, String s) {
		if (index == s.length()) {
			return left == right;
		}

		char c = s.charAt(index);
		if (c == '(') {
			return dfs(index + 1, left + 1, right, s);
		} else if (c == ')') {
			return dfs(index + 1, left, right + 1, s);
		} else {
			return dfs(index + 1, left + 1, right, s) || dfs(index + 1, left, right + 1, s)
					|| dfs(index + 1, left, right, s);
		}
	}

}

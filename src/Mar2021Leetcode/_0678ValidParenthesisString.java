package Mar2021Leetcode;

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

	public static boolean dfs(int left, int right, int index, String s) {
		if (index == s.length() && left == right)
			return true;
		if (index >= s.length() || right > left)
			return false;
		char c = s.charAt(index);
		if (c == '(') {
			return dfs(left + 1, right, index + 1, s);
		} else if (c == ')') {
			return dfs(left, right + 1, index + 1, s);
		} else {
			return dfs(left + 1, right, index + 1, s) || dfs(left, right + 1, index + 1, s)
					|| dfs(left, right, index + 1, s);
		}
	}

}

package April2021Leetcode;

public class _0678ValidParenthesisString {

	public static void main(String[] args) {
		System.out.println(checkValidString("()"));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*))"));
	}

	public static boolean checkValidString(String s) {
		if (s == null || s.length() == 0)
			return true;
		return checkValidString(0, 0, 0, s);
	}

	public static boolean checkValidString(int index, int left, int right, String s) {
		if (index == s.length() && left == right) {
			return true;
		}

		if (index >= s.length() || right > left)
			return false;

		char c = s.charAt(index);

		if (c == '(') {
			return checkValidString(index + 1, left + 1, right, s);
		} else if (c == ')') {
			return checkValidString(index + 1, left, right + 1, s);
		} else {
			return checkValidString(index + 1, left, right, s) || checkValidString(index + 1, left + 1, right, s)
					|| checkValidString(index + 1, left, right + 1, s);
		}
	}

}

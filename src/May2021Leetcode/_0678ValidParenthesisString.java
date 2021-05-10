package May2021Leetcode;

public class _0678ValidParenthesisString {

	public static void main(String[] args) {
		System.out.println(checkValidString("()"));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*))"));
	}

	public static boolean checkValidString(String s) {
		return isValid(0, 0, 0, s);
	}

	public static boolean isValid(int index, int left, int right, String s) {
		if (index == s.length()) {
			return left == right;
		}
		if (right > left)
			return false;

		char c = s.charAt(index);
		if (c == '(') {
			return isValid(index + 1, left + 1, right, s);
		} else if (c == ')') {
			return isValid(index + 1, left, right + 1, s);
		} else {
			return isValid(index + 1, left + 1, right, s) || isValid(index + 1, left, right + 1, s)
					|| isValid(index + 1, left, right, s);
		}
	}
}

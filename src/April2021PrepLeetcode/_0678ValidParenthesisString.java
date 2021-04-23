package April2021PrepLeetcode;

public class _0678ValidParenthesisString {

	public static void main(String[] args) {
		System.out.println(checkValidString("()"));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*))"));
	}

	public static boolean checkValidString(String s) {
		return validateString(0, 0, 0, s);
	}

	public static boolean validateString(int left, int right, int index, String s) {
		if (index == s.length()) {
			return left == right;
		}

		if (index >= s.length() || right > left)
			return false;

		char c = s.charAt(index);
		if (c == '(') {
			return validateString(left + 1, right, index + 1, s);
		} else if (c == ')') {
			return validateString(left, right + 1, index + 1, s);
		} else {
			return validateString(left, right, index + 1, s) || validateString(left + 1, right, index + 1, s)
					|| validateString(left, right + 1, index + 1, s);
		}
	}

}

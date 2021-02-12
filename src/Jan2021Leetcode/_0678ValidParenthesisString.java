package Jan2021Leetcode;

public class _0678ValidParenthesisString {

	public static void main(String[] args) {
		System.out.println(checkValidString("()"));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*))"));
	}

	public static boolean checkValidString(String s) {
		return checkValidString(0, 0, 0, s);
	}

	public static boolean checkValidString(int index, int leftCount, int rightCount, String s) {
		if (index == s.length() && leftCount == rightCount)
			return true;
		if (index >= s.length() || rightCount > leftCount)
			return false;

		char c = s.charAt(index);
		if (c == '(') {
			return checkValidString(index + 1, leftCount + 1, rightCount, s);
		} else if (c == ')') {
			return checkValidString(index + 1, leftCount, rightCount + 1, s);
		} else {
			return checkValidString(index + 1, leftCount, rightCount, s)
					|| checkValidString(index + 1, leftCount + 1, rightCount, s)
					|| checkValidString(index + 1, leftCount, rightCount + 1, s);
		}
	}

}

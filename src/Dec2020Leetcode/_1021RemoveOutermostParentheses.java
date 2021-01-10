package Dec2020Leetcode;

public class _1021RemoveOutermostParentheses {

	public static void main(String[] args) {
		System.out.println(removeOuterParentheses("(()())(())"));
		System.out.println(removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(removeOuterParentheses("()()"));
	}

	public static String removeOuterParentheses(String S) {

		int leftBraces = 0;
		int left = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (leftBraces == 0) {
				left = i;
				leftBraces++;
			} else {
				char c = S.charAt(i);
				if (c == '(') {
					leftBraces++;
				} else {
					if (leftBraces == 1) {
						leftBraces = 0;
						sb.append(S.substring(left + 1, i));
					} else {
						leftBraces -= 1;
					}
				}
			}
		}
		return sb.toString();
	}
}

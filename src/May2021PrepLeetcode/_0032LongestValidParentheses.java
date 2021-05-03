package May2021PrepLeetcode;

public class _0032LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses(")((()))"));
		System.out.println(longestValidParentheses(")((())())"));
		System.out.println(longestValidParentheses("()((())())"));
		System.out.println(longestValidParentheses(""));
	}

	public static int longestValidParentheses(String s) {
		int[] dp = new int[s.length()];
		int maxLength = 0;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == ')') {
				if (s.charAt(i - 1) == '(') {
					if (i - 2 >= 0) {
						dp[i] = dp[i - 2] + 2;
					} else {
						dp[i] = 2;
					}
				} else {
					if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
						dp[i] = i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0;

						if (i - 1 >= 0) {
							dp[i] += dp[i - 1] + 2;
						} else {
							dp[i] += 2;
						}
					}
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}
		return maxLength;
	}
}

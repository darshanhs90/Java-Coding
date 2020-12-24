package Dec2020Leetcode;

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
		if (s == null || s.length() < 2)
			return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 0;
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			if (s.charAt(i - 1) == '(') {
				dp[i] = 0;
			} else {
				if (i - 2 >= 0 && s.charAt(i - 2) == '(') {
					dp[i] = dp[i - 2] + 2;
				} else if (i - 2 >= 0 && s.charAt(i - 2) == ')') {
					if (i - 2 - dp[i - 1] >= 0 && s.charAt(i - 2 - dp[i - 1]) == '(') {
						dp[i] = dp[i - 2 - dp[i - 1]] + 2 + dp[i - 1];
					}
				}
			}

			max = Math.max(dp[i], max);
		}
		return max;
	}
}

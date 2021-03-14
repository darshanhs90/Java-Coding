package Jan2021Leetcode;

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
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			char currChar = s.charAt(i);
			if (currChar == ')') {
				if (s.charAt(i - 1) == '(') {
					if (i - 2 >= 0)
						dp[i] = dp[i - 2] + 2;
					else
						dp[i] = 2;
				} else {
					if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
						if (i - dp[i - 1] - 2 >= 0) {
							dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
						} else {
							dp[i] = dp[i - 1] + 2;
						}
					}
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
